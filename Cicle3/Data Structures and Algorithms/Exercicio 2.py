odometer_begin = 0.0
odometer_end = 0.0
fuel_lt_spended = 0.0
total_money = 0.0

def Km_Per_Liter_Consume():
    km_per_liter = (odometer_end - odometer_begin) / fuel_lt_spended
    return km_per_liter
def day_profit():    
    day_profit_value = total_money - (fuel_lt_spended * 0.90)
    return day_profit_value
    
    
    
odometer_begin = float(raw_input("Marcação do odômetro no início do dia"))
odometer_end = float(raw_input("Marcação do odômetro no fim do dia"))
fuel_lt_spended = float(raw_input("Litros de combustivel gasto"))
total_money = float(raw_input("Valor total recebido dos passageiros"))

print "Média do consumo em Km/Lt:", Km_Per_Liter_Consume()
print "Total de lucro líquido do dia:", day_profit()
