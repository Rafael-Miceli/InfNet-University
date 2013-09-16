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

    printf("Digite seu nome\n");
    gets(_funcionario.Name);
    printf("Digite sua Identidade\n");
    gets(_funcionario.Id);
    printf("Digite sua data de nascimento\n");
    gets(_funcionario.Birth);
    printf("Digite seu salario\n");
    scanf("%f", &_funcionario.Salary);

    printf("\n%s\n", _funcionario.Name);
    printf("%s\n", _funcionario.Id);
    printf("%s\n", _funcionario.Birth);
    printf("R$%.2f\n", _funcionario.Salary);


}
