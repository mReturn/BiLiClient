package com.mreturn.biliclient.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.ui.base.BaseRxActivity;
import com.mreturn.biliclient.utils.ClipBoardUtil;
import com.mreturn.biliclient.utils.CommonUtil;
import com.mreturn.biliclient.utils.ToastUtil;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/21.
 */

public class BrowserActivity extends BaseRxActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.pb)
    ContentLoadingProgressBar pb;

    private String url, title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_browser;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            url = intent.getStringExtra(Constant.EXTRA_URL);
            title = intent.getStringExtra(Constant.EXTRA_TITLE);
        }

//        ToastUtil.show("url: "+url);
        initWebView();

    }

    private void initWebView() {
        CommonUtil.initWebView(this, mWebView);
        setClient();
        mWebView.loadUrl(url);
    }

    private void setClient() {
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(BrowserActivity.this)
                        .setTitle(getString(R.string.app_name))
                        .setMessage(message)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.confirm();
                            }
                        });
                builder.setCancelable(false);
                builder.create().show();
                return true;
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress >80) pb.setVisibility(View.GONE);
            }
        });

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pb.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle(TextUtils.isEmpty(title) ? "详情" : title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_browser,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.menu_share:
                share();
                break;
            case R.id.menu_open:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            case R.id.menu_copy:
                ClipBoardUtil.getInstance().setText(this,url);
                ToastUtil.show("已复制");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"分享");
        intent.putExtra(Intent.EXTRA_TEXT,url);
        startActivity(Intent.createChooser(intent,title));
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack() && mWebView.copyBackForwardList().getSize()>0 && !mWebView.getUrl()
                .equals(mWebView.copyBackForwardList().getItemAtIndex(0).getOriginalUrl())){
            mWebView.goBack();
        }else {
            finish();
        }
    }

    public static void launch(Context context, String url, String title) {
        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra(Constant.EXTRA_URL, url);
        intent.putExtra(Constant.EXTRA_TITLE, title);
        context.startActivity(intent);
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mWebView != null) {
//            // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再
//            // destory()
//            ViewParent parent = mWebView.getParent();
//            if (parent != null) {
//                ((ViewGroup) parent).removeView(mWebView);
//            }
//
//            mWebView.stopLoading();
//            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
//            mWebView.getSettings().setJavaScriptEnabled(false);
//            mWebView.clearHistory();
//            mWebView.clearView();
//            mWebView.removeAllViews();
//
//            try {
//                mWebView.destroy();
//            } catch (Throwable ex) {
//
//            }
//        }
//    }

}
