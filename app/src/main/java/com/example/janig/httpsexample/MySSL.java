package com.example.janig.httpsexample;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;


/**
 * Create own SSL socket factory
 * the client using this socket factory will ONLY trust the certificate we provide here,
 * ie the Certificate in the Android system will not when we use this factory!!!
 */
public class MySSL {


    private static final String LOGTAG = "MySSL";

    /**
     * Get a SSL socket factory ONLY VALID FOR A SPECIFIC SSL CERTIFICATE stored under Android Assets
     * @parmeter assetManager for opening ssl certificate file, can't be null
     * @return a valid SSL socket factory OR NULL
     * */
    public static SSLSocketFactory getSSLSocketFactory(AssetManager assetManager) {
        SSLContext context = null;

        try {

            Certificate certificate = getCertificate(assetManager);

            KeyStore keyStore = createKeyStore(certificate);

            TrustManagerFactory tmf = createKeyTrustManager(keyStore);

            context = createSSLContext(tmf.getTrustManagers());

        } catch  (IOException | KeyStoreException | CertificateException | KeyManagementException | NoSuchAlgorithmException  ex) {
            Log.e(LOGTAG, "Failed when creating a SSLSocketFactory. exception:"+ex);
            context = null;
        }

        return context == null ? null : context.getSocketFactory();
    }

    /**
     * Get a valid Certificate from a asset file
     * @parmeter assetManager a valid assetManager for opening a SSL certificate file, can't be null
     * @return a valid X509 certificate OR an exception is thrown
     * */
    private static Certificate getCertificate(AssetManager assetManager) throws IOException, CertificateException {
        Certificate certificate = null;
        //This CA certificate is for DigiCert which is CA FOR Github
        final String certificateFilename = "DigiCertCASSLCertificate-DER-format.der";

        //This CA certificate is from Symatec and will NOT work with Github
        //final String certificateFilename = "SymatecSSLCertficate-DER-format.der";

        final CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        final BufferedInputStream certificateIS = new BufferedInputStream(assetManager.open(certificateFilename));
        try {
            certificate = certificateFactory.generateCertificate(certificateIS);
            final String organisatonInfo = ((X509Certificate) certificate).getSubjectDN().toString();
            final String certificateIssuerInfo = ((X509Certificate) certificate).getIssuerDN().toString();
            Log.d(LOGTAG, "Read a certificate from file:" +certificateFilename + " valid for organisation:" + organisatonInfo
                    + "and signed by:" + certificateIssuerInfo);
        } finally {
            certificateIS.close();
        }
        return certificate;
    }

    /**
     * Create a KeyStore containing our trusted CAs
     * @parmeter
     * */
    private static KeyStore createKeyStore(Certificate certificate) throws CertificateException, NoSuchAlgorithmException, IOException, KeyStoreException {
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", certificate);
        return keyStore;
    }

    /**
     * Create a TrustManager that trusts the CAs in our KeyStore
     * @parmeter keyStore a valid keyStore, can't be null
     * */
    private static TrustManagerFactory createKeyTrustManager(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);
        return tmf;
    }


    /**
     * Create an SSLContext that uses our TrustManager
     * @parmeter
     * */
    private static SSLContext createSSLContext(TrustManager[] trustManagers) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, trustManagers, null);
        return context;
    }



}
