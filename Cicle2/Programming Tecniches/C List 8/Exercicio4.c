#include <stdio.h>
#include <string.h>

const int _totAluno = 2;
const int _totNota = 2;

typedef struct{
    char Name[60];
    float Nota[2];
    float Media;
} Aluno;

CadastrarAluno(Aluno aluno[])
{
    int i, j;

    for(i = 0; i < _totAluno; i++)
    {
        printf("Digite o seu nome: \n");
        scanf("%s", aluno[i].Name);

        for(j = 0; j < _totNota; j++)
        {
            printf("Digite a sua nota%d\n", j + 1);
            scanf("%f", &aluno[i].Nota[j]);
        }
    }
}

ExibirAlunos(Aluno aluno[])
{
    int i, j;

    for(i = 0; i < _totAluno; i++)
    {
        aluno[i].Media = 0;

        printf("\n\nNome: %s", aluno[i].Name);
        for(j = 0; j < _totNota; j++)
        {
            printf("\nNota%d", j + 1);
            printf("\n%.2f", aluno[i].Nota[j]);
            aluno[i].Media += aluno[i].Nota[j];
        }
        printf("\nMedia:%.2f\n", aluno[i].Media / 2);
    }
}

ExibirMediaTurma(Aluno aluno[])
{
    int i;
    float mediaTurma = 0, totTurma = 0;

    for(i = 0; i < _totAluno; i++)
    {
        totTurma += aluno[i].Media;
    }

    mediaTurma = (totTurma / (i + 1));
    printf("\n\nMedia da Turma: %.2f", mediaTurma);
}

ExibirMelhorAluno(Aluno aluno[])
{
    int i = 0;
    Aluno melhorAluno;

    strcpy(melhorAluno.Name, aluno[i].Name);
    melhorAluno.Media = aluno[i].Media;

    i++;

    for(i = 1; i < _totAluno; i++)
    {
        if(melhorAluno.Media < aluno[i].Media)
        {
            strcpy(melhorAluno.Name, aluno[i].Name);
            melhorAluno.Media = aluno[i].Media;
        }
    }

    printf("\n\nMelhor aluno: %s", melhorAluno.Name);
}

main()
{
    Aluno _aluno[_totAluno];

    CadastrarAluno(_aluno);
    ExibirAlunos(_aluno);
    ExibirMediaTurma(_aluno);
    ExibirMelhorAluno(_aluno);

}
