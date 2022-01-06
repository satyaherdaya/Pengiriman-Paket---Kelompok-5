package model;

import helper.KoneksiDB;
import java.sql.*;

public abstract class KoneksiDataBase {
    protected String sql;
    protected Connection conn = KoneksiDB.getKoneksi();
    
}
