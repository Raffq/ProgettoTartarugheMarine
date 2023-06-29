package DAO;

import java.sql.*;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException;
}
