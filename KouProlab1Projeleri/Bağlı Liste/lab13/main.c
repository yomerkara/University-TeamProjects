#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node
{
    char kelime[20];
    int kelimeSayisi;
    struct node*next;
};
struct node2
{
    char kelime2[20];
    int kelimeSayisi2;
    struct node2*next;
};

void sirala(struct node *root)
{
    struct node2  *root2;
    root2=(struct node *)malloc(sizeof(struct node));
    root2->next=NULL;
    struct node2 *it2=root2;

    while(root->next != NULL)
    {


        if(it2->next == NULL)
        {
            strcpy(it2->kelime2,root->kelime);
            it2->kelimeSayisi2=root->kelimeSayisi;
            it2->next=(struct node2 *)malloc(sizeof(struct node2));
            it2=it2->next;
            it2->next=NULL;



        }
        else if(it2->kelimeSayisi2 < root->kelimeSayisi)
        {
            struct node2 * temp = (struct node2 *)malloc(sizeof(struct node2));
            strcpy(temp->kelime2,root->kelime);
            temp->kelimeSayisi2=root->kelimeSayisi;
            temp->next=root2;
            root2=temp;

        }
        else
        {
            while(it2->next != NULL && it2->next->kelimeSayisi2 > root->kelimeSayisi)
            {
                it2=it2->next;
            }

            if(it2->next!=NULL)
            {

                struct node2 * temp = (struct node2 *)malloc(sizeof(struct node2));
                strcpy(temp->kelime2,root->kelime);
                temp->kelimeSayisi2=root->kelimeSayisi;
                temp->next=it2->next;
                it2->next=temp;


            }

            if(it2->next==NULL)
            {
                strcpy(it2->kelime2,root->kelime);
                it2->kelimeSayisi2=root->kelimeSayisi;
                it2->next=(struct node2 *)malloc(sizeof(struct node2));
                it2->next->next=NULL;

            }
        }
        root=root->next;
        it2=root2;
    }
    it2=root2;
    int i=0;
    while(it2->kelime2 != NULL)
    {
        printf("%d) %s -> %d\n",i,it2 -> kelime2,it2->kelimeSayisi2);
        it2=it2->next;
        i++;
    }
}
int main()
{
    FILE *dosya=fopen("dosya.txt","r");
    if(dosya==NULL)
    {
        printf("Dosya ac??l??rken hata olustu!!\n Programdan cikiliyor!!");
        exit(1);
    }
    struct node  *root;
    root=(struct node *)malloc(sizeof(struct node));
    root->next=NULL;
    struct node *iter=root;
    char gecici[20];

    while(!feof(dosya))
    {

        fscanf(dosya,"%s",gecici);
        if(iter->next == NULL)
        {
            strcpy(iter -> kelime,gecici);
            iter->kelimeSayisi=1;
            iter -> next=(struct node*)malloc(sizeof(struct node));
            iter = iter -> next;
            iter->next=NULL;

        }
        else
        {

            while (iter->next != NULL)
            {


                if(strcmp(iter->kelime,gecici)==0)
                {
                    iter->kelimeSayisi++;
                    break;

                }
                if(strcmp(iter->kelime,gecici)!=0)
                {

                    if(iter->next->next == NULL)
                    {
                        iter=iter->next;
                        strcpy(iter -> kelime,gecici);
                        iter->kelimeSayisi=0;
                        iter -> next=(struct node*)malloc(sizeof(struct node));
                        iter->next->next= NULL;
                    }
                    else
                    {

                        iter=iter->next;
                    }

                }
            }
        }


        iter=root;
    }

    sirala(root);
    return 0;
}
