<%@ page import="java.util.*,beans.*" %><%--
  Created by IntelliJ IDEA.
  User: weiling
  Date: 24/10/18
  Time: 下午1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
      <base href="<%=basePath%>">
    <title>原生态JAVA生成报表</title>
      <style type="text/css">
          table.hovertable{
              font-family: Verdana,Arial,sans-serif;
              font-size: 13px;
              color: #333333;
              border-width: 1px;
              border-color: #999999;
              border-collapse: collapse;
          }

          table.hovertable th{
              background-color: #c3dde0;
              border-width: 1px;
              padding: 8px;
              border-style: solid;
              border-color: #a9c6c9;
          }

          table.hovertable tr{
              background-color: #d4e3e5;
          }
          table.hovertable td{
              border-width: 1px;
              padding: 8px;
              border-style: solid;
              border-color: #a9c6c9;
          }
      </style>
  </head>

  <body>
  <form action = "ShowReport" method="post">
      <input type="submit" value="生成报表">

  </form>
  <table class="hovertable">
      <tr>
          <th colspan="6">利润表</th>
      </tr>
      <tr>
          <th>报表编号</th>
          <th>商品名称</th>
          <th>商品利润</th>
          <th>销售数量</th>
          <th>交易笔数</th>
          <th>收入</th>
      </tr>
      <%
          List list = null;
          if(session.getAttribute("PROFIT")!= null){
              list = (List)session.getAttribute("PROFIT");
              if(list.size() > 0){
                  int temp1 = 0;
                  int temp2 = 0;
                  int temp3 = 0;
                  Profit pf;
                  for (int i = 0; i < list.size(); i++) {
                    pf = new Profit();
                    pf = (Profit) list.get(i);
                    temp1 += pf.getTradingNum();
                    temp2 += pf.getTimes();
                    temp3 += pf.getIncome();
      %>
      <tr>
          <td><%=i+1%></td>
          <td><%=pf.getGoodsName()%></td>
          <td><%=pf.getProfit()%></td>
          <td><%=pf.getTradingNum()%></td>
          <td><%=pf.getTimes()%></td>
          <td><%=pf.getIncome()%></td>
      </tr>
      <%
          }
      %>
      <tr>
          <td colspan="3" align="center">合计：</td>
          <td><%=temp1%></td>
          <td><%=temp2%></td>
          <td><%=temp3%></td>
      </tr>
      <%
          } }
      %>
  </table>

  </body>
</html>
