#class Person():
    

person_list = []
person_dict = { "age": 0, "gender": "", "civil_status": ""}
age = 0
gender = "" 
civil_status = ""

def show_list(person_lst):
    for person in person_lst:        
        for key in person:
            print key, " ", person[key]
    return 0

def merrieds(person_lst):
    total_merried = 0
    for person in person_lst:
        if person["civil_status"].lower() == "c":
            total_merried += 1
    return total_merried
    
def women_single_over_thirty(person_lst):
    total_women_single_over_thirty = 0
    for person in person_lst:
        if person["gender"].upper() == "F" and person["civil_status"].lower() == "s" and person["age"] > 30:
            total_women_single_over_thirty += 1
    return total_women_single_over_thirty

def widower_average_men_age(person_lst):
    average = 0
    total_age = 0
    for person in person_lst:
        if person["gender"].upper() == "M" and person["civil_status"].lower() == "v":
            total_age += person["age"]
            average += 1
    if average > 0:
        return total_age / average
    else:
        return 0    
        
def minos_18_divorced_percent(person_lst):
    total_men = 0
    total_women = 0
    for person in person_lst:
        if person["civil_status"].lower() == "d" and person["age"] < 18:
            if person["gender"].upper() == "M":
                total_men += 1
            else:
                total_women += 1          
    print total_men
    print total_women
    print "Percentual de homens separados com menos de 18:", ((total_men * 100) / float(len(person_list)))
    print "Percentual de mulheres separadas com menos de 18:", ((total_women * 100) / float(len(person_list)))
    return 0

age = int(raw_input("Diga a idade:")) 
while age > 0:
    gender = raw_input("Digite o sexo da pessoa: M/F")
    while not(gender.upper() == "M" or gender.upper() =="F"):
        gender = raw_input("Valor inválido, digite novamente o sexo da pessoa:")
    civil_status = raw_input("Digite o estado civil da pessoa: c/s/v/d")
    while not(civil_status.lower() == "c" or civil_status.lower() =="s" or civil_status.lower() == "v" or civil_status.lower() =="d"):
        civil_status = raw_input("Valor inválido, digite novamente o estado civil da pessoa: c/s/v/d")
    person_dict["age"] = age
    person_dict["gender"] = gender
    person_dict["civil_status"] = civil_status
    person_list.append(person_dict.copy())
    
    age = int(raw_input("Diga a idade:"))

print "Pessoas casadas:", merrieds(person_list)
print "Mulheres solteiras com mais de 30 anos:", women_single_over_thirty(person_list)
print "Média da ideda de homens viúvos:", widower_average_men_age(person_list)
minos_18_divorced_percent(person_list)