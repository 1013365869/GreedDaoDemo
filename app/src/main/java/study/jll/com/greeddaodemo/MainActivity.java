package study.jll.com.greeddaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import study.jll.com.greeddao.SutdentDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_add;
    private Button bt_del;
    private Button bt_update;
    private Button bt_select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_add = findViewById(R.id.bt_add);
        bt_del = findViewById(R.id.bt_del);
        bt_update = findViewById(R.id.bt_update);
        bt_select = findViewById(R.id.bt_select);

        bt_add.setOnClickListener(this);
        bt_del.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                Sutdent sutdent =new Sutdent(1L,"123","1243",1);
                try {
                    MyApplication.getInstances().getDaoSession().insert(sutdent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("jll","数据库插入失败咯咯");
                }

                break;
            case R.id.bt_del:
                try {
                   List<Sutdent> list =  MyApplication.getInstances().getDaoSession().getSutdentDao().queryBuilder().where(SutdentDao.Properties.Uuid.eq("123")).list();
                    if (list.size()>0) {
                        MyApplication.getInstances().getDaoSession().getSutdentDao().delete(list.get(0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("jll","数据删除成功");
                }
                break;
            case R.id.bt_update:
                try {
                    List<Sutdent> list =   MyApplication.getInstances().getDaoSession().getSutdentDao().queryBuilder().where(SutdentDao.Properties.Uuid.eq("123")).list();
                    if (list.size()>0) {
                        list.get(0).setWaypointList("8888");
                        MyApplication.getInstances().getDaoSession().getSutdentDao().updateInTx(list.get(0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("jll","数据库bt_update失败咯咯");
                }

                break;
            case R.id.bt_select:
              List<Sutdent> list =   MyApplication.getInstances().getDaoSession().getSutdentDao().loadAll();

              Log.i("jll"," list.toString()"+list.toString());
                break;
        }
    }
}
