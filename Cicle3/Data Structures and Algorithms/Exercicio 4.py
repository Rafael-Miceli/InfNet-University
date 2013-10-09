dividendo = 1000.00
divisor = 1.0
total_value = 0.0

total_value = dividendo / divisor
print total_value

for index in range(2, 50, 1):
    dividendo -= 3
    divisor += 1
    if divisor % 2 == 0:
        total_value -= dividendo / divisor
        print total_value
    else:
        total_value += dividendo / divisor
        print total_value