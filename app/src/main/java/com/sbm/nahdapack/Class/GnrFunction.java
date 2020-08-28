package com.sbm.nahdapack.Class;

import android.util.AndroidRuntimeException;
import android.util.Log;
import android.widget.Spinner;

import java.io.IOError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GnrFunction {

    private   String tbl_name="",vr_sql_statment="",vr_sql_msg="";
    private   int vr_id_del=0;
    Connection con;

    public void SQLEXEQUTE(String SQL_STATMENT,String MSG) {
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            // encodedImage which is the Base64 String
            PreparedStatement preStmt=con.prepareStatement(commands);
            preStmt.executeUpdate();
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
    }

    public Boolean GetDataBool(String SQL_STATMENT,String MSG) {
        Boolean NO_DATA=false;
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(commands);

            if (rs != null){
                if(rs.next()){NO_DATA=false;}
                else { NO_DATA=true;}
            }
            else  { NO_DATA=true;}
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        return NO_DATA;
    }
    public Boolean DeleteBool(String SQL_STATMENT,String MSG) {
        Boolean deleted=false;
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(commands);

            if (rs != null){
                if(rs.next()){deleted=false;}
                else { deleted=true;}
            }
            else  { deleted=true;}
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        return deleted;
    }

    public List<String> GetArrayList(String SQL_STATMENT, String COL_NAME, String MSG) {
        List<String> arrayList=new ArrayList<String>();
        arrayList.add("-Select-");
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(commands);
            if (rs != null){
                while (rs.next()){
                    arrayList.add(rs.getString(COL_NAME));
                }
            }
            else  { arrayList=null;}
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        return arrayList;
    }

    public List<String> GetArrayListSp(String SQL_STATMENT,String COL_NAME, String MSG) {
        List<String> arrayList=new ArrayList<String>();
        //arrayList.add("-Select-");
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(commands);
            if (rs != null){
                while (rs.next()){
                    arrayList.add(rs.getString(COL_NAME));
                }
            }
            else  { arrayList=null;}
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        return arrayList;
    }
    public String GetIdByString(String SQL_STATMENT,String COL_NAME, String MSG) {
        String vr_id="" ;
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(commands);
            if (rs != null){
                if (rs.next()){
                    vr_id=rs.getString(COL_NAME);
                }
            }
            else  { vr_id="0";}
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        return vr_id;
    }
    public ResultSet GetAllData(String SQL_STATMENT, String MSG) {
        ResultSet rs_return=null ;
        vr_sql_statment=SQL_STATMENT;vr_sql_msg=MSG;
        String msg="unknown";
        try {
            ConnectionHelper conStr=new ConnectionHelper();
            con=ConnectionHelper.connectionclasss(conStr);
            String commands=vr_sql_statment;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(commands);
            if (rs != null){
                rs_return=rs;

            }
            else  { rs_return=null;}
            msg=vr_sql_msg;
        } catch (SQLException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (IOError ex) {
            // TODO: handle exception
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (AndroidRuntimeException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);

        } catch (NullPointerException ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        } catch (Exception ex) {
            msg=ex.getMessage().toString();
            Log.d("hitesh", msg);
        }
        return rs_return;
    }
    public void setSpinText(Spinner spin, String text)
    {
        for(int i= 0; i < spin.getAdapter().getCount(); i++)
        {
            if(spin.getAdapter().getItem(i).toString().contains(text))
            {
                spin.setSelection(i);
            }
        }

    }

}
