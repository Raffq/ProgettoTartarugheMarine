package DAO;

import java.sql.*;
import java.util.List;

public interface DAO<T> {
    T get(String id) throws SQLException;
}
