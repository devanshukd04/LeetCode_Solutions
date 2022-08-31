# Write your MySQL query statement below
select stock_name,sum(gain) as capital_gain_loss from(select stock_name,operation, 
case
    when operation='Buy' then -1*sum(price)
        else sum(price)
    End as gain
    from Stocks
    group by stock_name,operation)
as stockCapital group by stock_name; 