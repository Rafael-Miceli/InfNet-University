employees_count = 0.0
salary = 0.0
bike_price = 0.0
total_bike_selled = 0.0

def total_salary_each_employee():
    total_employee_salary = (salary * 2) + (total_bike_selled * (bike_price * 15 / 100))    
    return total_employee_salary
def store_profit():
    store_profit_value = ((bike_price + (bike_price * 50 / 100)) * total_bike_selled) - total_salary_each_employee()
    return store_profit_value
    
    
    
employees_count = float(raw_input("Quantos funcionarios possui sua loja?"))
salary = float(raw_input("Qual o valor do salário mínimo?"))
bike_price = float(raw_input("Qual o preço de custo de cada bicicleta?"))
total_bike_selled = float(raw_input("Quantas bicicletas foram vendidas?"))

print "Total de salario dos funcionario: ", total_salary_each_employee()
print "Total de lucro líquido da loja é: ", store_profit()
