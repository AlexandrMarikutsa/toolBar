package com.demo.alexandr.myapp.activities;


import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.demo.alexandr.myapp.R;
import com.demo.alexandr.myapp.constants.StringConstants;
import com.demo.alexandr.myapp.tasks.DownloadDocumentTask;
import com.demo.alexandr.myapp.tasks.ExtractAssetTask;
import com.pspdfkit.PSPDFKit;
import com.pspdfkit.configuration.PSPDFConfiguration;
import com.pspdfkit.configuration.activity.PSPDFActivityConfiguration;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.exceptions.PSPDFInitializationFailedException;
import com.pspdfkit.ui.PSPDFAppCompatActivity;

import java.io.File;

public class PDFActivity extends BaseActivity {
    private static final String DEMO_DOCUMENT_ASSET_NAME = "demo.pdf";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_layout);

//        try {
//            PSPDFKit.initialize(this, "YOUR_LICENSE_KEY_GOES_HERE");
//        } catch (PSPDFInitializationFailedException e) {
//            Log.e("LICENSE PROBLEMS: ", "Current device is not compatible with PSPDFKit!");
//        }

//        openDemoDocument();

//        createPSPDFConfiguration();
    }

//    private void createPSPDFConfiguration() {
//        PSPDFConfiguration configuration = new PSPDFConfiguration.Builder(StringConstants.LICENSE)
//                .scrollDirection(PageScrollDirection.HORIZONTAL)
//                .build();
//    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_edit).setVisible(false);
        menu.findItem(R.id.action_add).setVisible(false);
        return true;
    }

    private void showPdfDocument(Uri uri) {
        final PSPDFActivityConfiguration pspdfkitConfiguration = new PSPDFActivityConfiguration.Builder(getApplicationContext(), StringConstants.LICENSE)
                .scrollDirection(PageScrollDirection.HORIZONTAL)
                .showPageNumberOverlay()
                .showThumbnailGrid()
                .showThumbnailBar()
                .fitMode(PageFitMode.FIT_TO_WIDTH)
                .build();

        if (PSPDFKit.isOpenableUri(this, uri)) {
            PSPDFAppCompatActivity.showDocument(this, uri, pspdfkitConfiguration);
        } else {

            // Only document accessible as files are openable directly with PSPDFKit so we have to
            // transfer other documents to application cache
            DownloadDocumentTask task = new DownloadDocumentTask(this, new DownloadDocumentTask.DownloadedFileCallback() {
                @Override
                public void onFileDownladed(Uri uri) {
                    PSPDFAppCompatActivity.showDocument(PDFActivity.this, uri, pspdfkitConfiguration);
                }
            });

            task.execute(uri);
        }
    }

    private void openDemoDocument() {
        final File demoDocumentFile = new File(getFilesDir(), DEMO_DOCUMENT_ASSET_NAME);
        if (demoDocumentFile.exists()) {
            showPdfDocument(Uri.fromFile(demoDocumentFile));
        } else {
            ExtractAssetTask task = new ExtractAssetTask(this, new DownloadDocumentTask.DownloadedFileCallback() {
                @Override
                public void onFileDownladed(Uri uri) {
                    showPdfDocument(uri);
                }
            });
            task.execute(DEMO_DOCUMENT_ASSET_NAME);
        }
    }

}
