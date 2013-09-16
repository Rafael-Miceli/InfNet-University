#include <stdio.h>
#include <string.h>

typedef struct{
        char Name[40];
        char Id[14];
        char Birth[12];
        float Salary;
    } Funcionario;

void SetFuncionario(Funcionario *funcionario)
{
    printf("Digite seu nome\n");
    gets(funcionario->Name);
    printf("Digite sua Identidade\n");
    gets(funcionario->Id);
    printf("Digite sua data de nascimento\n");
    gets(funcionario->Birth);
    printf("Digite seu salario\n");
    scanf("%f", &funcionario->Salary);
}

void ExibeFuncionario(Funcionario funcionario)
{
    printf("\n%s\n", funcionario.Name);
    printf("%s\n", funcionario.Id);
    printf("%s\n", funcionario.Birth);
    printf("R$%.2f\n", funcionario.Salary);
}


main()
{
    Funcionario _funcionario;

    SetFuncionario(&_funcionario);
    ExibeFuncionario(_funcionario);

}


