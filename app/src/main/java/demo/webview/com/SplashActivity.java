package demo.webview.com;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.io.IOException;

public class SplashActivity extends FragmentActivity {

    private String fileName = Config.FILENAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFileExists(fileName)) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SplashActivity.this, "激活失败", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        }, 1500);

    }

    /**
     * 判断assets文件夹下的文件是否存在
     *
     * @return false 不存在    true 存在
     */
    private boolean isFileExists(String filename) {
        AssetManager assetManager = getAssets();
        try {
            String[] names = assetManager.list("");
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(filename.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
