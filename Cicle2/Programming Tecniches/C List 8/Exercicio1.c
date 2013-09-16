#include <stdio.h>
#include <string.h>

main()
{
    typedef struct{
        char Name[40];
        char Id[14];
        char Birth[12];
        float Salary;
    } Funcionario;

    Funcionario _funcionario;

    strcpy(_funcionario.Name, "Rafael");
    strcpy(_funcionario.Id, "21.774.894-6");
    strcpy(_funcionario.Birth, "07/12/1989");
    _funcionario.Salary = 5000;

    printf("%s\n", _funcionario.Name);
    printf("%s\n", _funcionario.Id);
    printf("%s\n", _funcionario.Birth);
    printf("R$%.2f\n", _funcionario.Salary);


}
