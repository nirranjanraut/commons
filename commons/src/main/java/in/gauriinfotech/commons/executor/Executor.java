package in.gauriinfotech.commons.executor;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by NiRRaNjAN on 20/10/16.
 */
public class Executor extends AsyncTask<String, Void, Boolean> {

    private static final String tag = "Executor.java";
    private String HOST;
    private String USER;
    private String PASSWORD;
    private String DATABASE;
    private String query;
    private CallBackReceiver receiver;
    private Connection connection;
    private List<Map<String, String>> result = new ArrayList<>();
    private boolean debug = false;

    public Executor(String query) {
        this.query = query;
    }

    public Executor callbackReceiver(CallBackReceiver receiver) {
        this.receiver = receiver;
        return this;
    }

    public Executor credentials(String host, String user, String password, String database) {
        this.HOST = host;
        this.USER = user;
        this.PASSWORD = password;
        this.DATABASE = database;
        return this;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private boolean connect() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://"+HOST+";user="+USER+";password="+PASSWORD+";databaseName=" + DATABASE);
            return true;
        } catch (Exception ex) {
            Log.e(tag, "Error connecting to server.");
            Log.e(tag, Log.getStackTraceString(ex));
        }
        return false;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... args) {
        try {
            SystemClock.sleep(500);
            if(!connect()) {
                return false;
            }
            if(debug) {
                StringBuilder builder = new StringBuilder();
                int i=0;
                for (String param : args) {
                    if(i != 0) {
                        builder.append(", ");
                    }
                    builder.append(param);
                    i++;
                }
                Log.e(tag, builder.toString());
            }
            CallableStatement statement = connection.prepareCall(query);
            if(args != null && args.length > 0) {
                for(int i=0;i<args.length;i++) {
                    statement.setString(i + 1, args[i]);
                }
            }
            if(debug) {
                Log.e(tag, "Statistics for : " + query);
            }
            if(statement.execute()) {
                do {
                    ResultSet result = statement.getResultSet();
                    ResultSetMetaData metaData = result.getMetaData();
                    int count = metaData.getColumnCount();
                    while (result.next()) {
                        Map<String, String> record = new HashMap<>();
                        for (int i = 1; i <= count; i++) {
                            String columnName = metaData.getColumnName(i);
                            String value = result.getString(i);
                            if (debug) {
                                Log.e(tag, columnName + " : " + value);
                            }
                            record.put(columnName, value);
                        }
                        this.result.add(record);
                    }
                    result.close();
                } while(statement.getMoreResults());
            }
            connection.close();
        } catch (Exception ex) {
            Log.e(tag, Log.getStackTraceString(ex));
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        receiver.onDone(result);
        super.onPostExecute(aBoolean);
    }

}