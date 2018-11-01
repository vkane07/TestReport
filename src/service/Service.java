package service;

import beans.Profit;
import jdbc.JdbcConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Connection dbconnection;
    private PreparedStatement st;
    private ResultSet rs;
    private String sql;
    private List list;
    private Profit pf;

    public List getProfit() {
        list = new ArrayList();
        dbconnection = JdbcConn.getConnection();
        try {

            sql = "select g.name as name,(g.sell_price-g.cost_price) as profit,sum(t.number) as sellnumber,count(t.id) as tscnumber,((g.sell_price-g.cost_price)*sum(t.number)) as income" +
                    " from goods g,transaction t where g.id = t.goods_id;";
            st = (PreparedStatement) dbconnection.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while (rs.next()) {
                pf = new Profit();
                pf.setGoodsName(rs.getString("name"));
                pf.setProfit(rs.getInt("profit"));
                pf.setTradingNum(rs.getInt("sellnumber"));
                pf.setTimes(rs.getInt("tscnumber"));
                pf.setIncome(rs.getInt("income"));
                list.add(pf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Integer> getIds() {
        List<Integer> idslist = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            String sql = "select goods_id from transaction group by goods_id";
            conn = JdbcConn.getConnection();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("goods_id");
                idslist.add(id);
            }
            return idslist;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psmt != null) {
                try {
                    psmt.close();
                    psmt = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}

    public static void main(String[] args) {
        Service service = new Service();
        List<Profit> idslist = service.getProfit();
        if(idslist != null && idslist.size()>0){
            for (Profit profit:idslist) {
                System.out.println(profit.getProfit());
            }
            System.out.println("getIds");
        }
    }
}
