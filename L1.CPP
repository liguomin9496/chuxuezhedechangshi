#include <stdio.h>
void main()
{
  int i, j, k, l, m;  char c=3;
  for (i=1; i<=5; i++)      printf("\n");
  for (i=1; i<=3; i++)
  {
    for (j=1; j<=32-2*i; j++)  printf(" ");  
    for (k=1; k<=4*i+1; k++)  printf("%c", c);
    for (l=1; l<=13-4*i; l++)  printf(" ");
    for (m=1; m<=4*i+1; m++)  printf("%c", c);
    printf("\n");
  }
  for (i=1; i<=3; i++)
  {
    for (j=1; j<=24+1; j++)    printf(" ");  
    for (k=1; k<=29; k++)    printf("%c", c);
    printf("\n");
  }
  for (i=7; i>=1; i--)
  {
    for (j=1; j<=40-2*i; j++)  printf(" ");  
    for (k=1; k<=4*i-1; k++)  printf("%c", c);
    printf("\n");
  }
  for (i=1; i<=39; i++)      printf(" ");
  printf("%c\n", c);
  for (i=1; i<=4; i++)      printf("\n");
}