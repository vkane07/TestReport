package beans;

public class Profit {
    private String goodsName;
    //利润
    private int profit;
    private int goodsId;
    private int costPrice;
    private int sellingPrice;
    //交易数量
    private int tradingNum;
    //交易笔数
    private int times;
    //交易收入

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    private int income;
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getTradingNum() {
        return tradingNum;
    }

    public void setTradingNum(int tradingNum) {
        this.tradingNum = tradingNum;
    }

    public int getTimes() {
        return times;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setTimes(int times) {
        this.times = times;
    }


}
