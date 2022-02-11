#include <stdio.h> 
#include <stdlib.h>
#include <math.h>
#include <graphics.h>
void sirala(int koordinatM[][2],int N)
{
	//Buble sort algoritmasi ile siralama yapildi.
	int temp[2];
	int i,j;
	for(i=1;i<N;i++)
	for(j=0;j<N-i;j++)
	{
		if(koordinatM[j+1][0]<=koordinatM[j][0])
		{	
			temp[0]=koordinatM[j][0];
			temp[1]=koordinatM[j][1];
			koordinatM[j][0]=koordinatM[j+1][0];
			koordinatM[j][1]=koordinatM[j+1][1];
			koordinatM[j+1][0]=temp[0];
			koordinatM[j+1][1]=temp[1];
						
							if(koordinatM[j+1][0]==koordinatM[j][0] && koordinatM[j+1][0]==koordinatM[j][0])
						{
						printf("Iki ayni nokta verilmemeli!");
						}
		}
	}
}
    void kucuk_cember(int koordinatM[][2],int N)
  {
  	//Noktalardan ge�en en k���k �ember.
  	int	xmesafe=0;
  	int ymesafe=0;
  	float mesafe=0.0;
  	float en_uzakM=mesafe;
  	int tuti=0,tutj=0;
  	
  	for(int i=0;i<N;i++){
  		for(int j=0;j<=i;j++)
  		{	
		  	xmesafe=fabs(koordinatM[j][0]-koordinatM[i][0]);
  			ymesafe=fabs(koordinatM[j][1]-koordinatM[i][1]);
  			mesafe = sqrt(pow(ymesafe,2)+pow(xmesafe,2)); 
  			
		 //en uzak mesafeyi bulduruyoruz.
		  if(mesafe>en_uzakM)
		  {
		  	en_uzakM=mesafe;
		  		//en uzak mesafesi olan noktalar� parametrede tutuyoruz.
		  			tuti=i;
		  			tutj=j;
		  }
		  	}
		  xmesafe=0;
		  ymesafe=0;
		  mesafe=0;
		   		}
		   			
	  			//orta nokta bulunuyor.
	  		float ortaNoktax=0.0;
			   float ortalamax=(koordinatM[tutj][0]-koordinatM[tuti][0])/2.0;
			   		if(ortalamax<0.0)
			   			{
			   				ortaNoktax=koordinatM[tutj][0]+fabs(ortalamax);
			  					 }else ortaNoktax=koordinatM[tuti][0]+ortalamax;
	  		float ortaNoktay;
			  float ortalamay=(koordinatM[tutj][1]-koordinatM[tuti][1])/2.0;
	  					if(ortalamay<0.0)
			   				{
			   				ortaNoktay=koordinatM[tutj][1]+fabs(ortalamay);
			   						}else ortaNoktay=koordinatM[tuti][1]+ortalamay;
	  		
			  printf("Merkez Koordinat:(x)%f,(y)%f\n",ortaNoktax,ortaNoktay);
			  printf("Merkez yaricap: %f\n",(en_uzakM)/2.0);
	  	
	  		
	  		
	  		setcolor(RED);
	  		circle(ortaNoktax,ortaNoktay,((en_uzakM)/2.0));
	  		setcolor(GREEN);
	  		line(ortaNoktax,ortaNoktay,koordinatM[tuti][0],koordinatM[tuti][1]);
	  		settextstyle(2,0,5);
	  		outtextxy(ortaNoktax,ortaNoktax,"(x,y)");
  }
  int fak(int x)
  {
  	int sonuc=1;
  	if(x==0 || x==1)
  	{
  		sonuc=1;
	  }else{
	  	for(int i=2;i<=x;i++)
	  	{
	  		sonuc*=i;
		  }
	  }
  	
  	return sonuc;
  }
  int sign(float x)
  {
  	if(x<0){
	 return -1; }
  	
  	else if(x>0){
	return 1;  }
  	
  	else if(x==0)  return 0;
  }
 void egri(int koordinatM[][2],int N)
 {
 	int i,j;
 	int egim[N-1];
 	int kontrolN[1][2];
 	int baslangic[1][2];
	baslangic[0][0]=koordinatM[0][0];
 	baslangic[0][1]=koordinatM[0][1];
 	/*	int tegetBasAci=0;
 	int tegetBitAci=0;
 	int kontrolNr=0;*/
 	
		for(i=1;i<N;i++)
		{
				egim[i-1]=sign((float)(koordinatM[i][1]-koordinatM[i-1][1])/(koordinatM[i][0]-koordinatM[i-1][0]));
			
		}
		int ilk=egim[0];
		int degisimS=0;
		
						for(j=0;j<N-1;j++)
				{
					if(egim[j]!=ilk)
					{
						degisimS++;
						ilk=egim[j];
					}
				}
				int kontrolNoktalari[degisimS][2];
				int a=0;
								for(j=0;j<N-1;j++){
								if(egim[j]!=ilk){
									for(int k=0;k<degisimS;k++)
									{
							kontrolNoktalari[a][0]=koordinatM[j][0];
						kontrolNoktalari[a][1]=koordinatM[j][1];
						ilk=egim[j];
									}
									a++;	
								}
						}
												setcolor(5);
											for(int k=0;k<degisimS;k++)
											{
												line(baslangic[0][0],baslangic[0][1],kontrolNoktalari[k][0],kontrolNoktalari[k][1]);
												baslangic[0][0]=kontrolNoktalari[k][0];
												baslangic[0][1]=kontrolNoktalari[k][1];
												printf("Kontrol Noktalarinin koordinatlari :%d %d\n",kontrolNoktalari[k][0],kontrolNoktalari[k][1]);
											}	
											
									setcolor(WHITE);		
									for(i=0;i<N-1;i++)
									{	line(koordinatM[i][0],koordinatM[i][1],koordinatM[i+1][0],koordinatM[i+1][1]);
											}
				//Buradan sonras� yap�lan hesaplamalarla arc() kullan�larak kontrol noktalar�nda te�et ge�irmek i�indir.
		/*		
		
		for(i=1;i<N;i++)
			for(j=i-1;j<N;j++)
			
						if(egim[j]!=egim[i])
				{
					
					kontrolN [0][0]=koordinatM[i][0];
 					kontrolN [0][1]=koordinatM[i][1];
					kontrolOrtaNx=baslangic[0][0]+fabs((kontrolN [0][0]-baslangic[0][0])/2);
					printf("kontrolOrtaNx %d\n",kontrolOrtaNx);
 					kontrolOrtaNy=baslangic[0][1]+fabs((kontrolN [0][1]-baslangic[0][1])/2);
 					printf("kontrolOrtaNy %d\n",kontrolOrtaNy);
 					tegetBasAci=(kontrolOrtaNy-baslangic[0][1])/(kontrolOrtaNx-baslangic[0][0]);
 					printf("tegetBasAci %d\n",tegetBasAci);
 					tegetBitAci=(kontrolN[0][1]-kontrolOrtaNy)/(kontrolN[0][0]-kontrolOrtaNx);
 					printf("tegetBitAci %d\n",tegetBitAci);
 					kontrolNr=sqrt(pow(kontrolN[0][1]-baslangic[0][1],2)+pow(kontrolN[0][0]-baslangic[0][0],2))/2;
 					printf("kontrolNr %d\n",kontrolNr);
 				

				}
 						
		 			baslangic[0][0]=kontrolN[0][0];
 					baslangic[0][1]=kontrolN[0][1];			 	
*/
		
 }

  int main() 
  { 

		//Dosyadan noktalar okundu.
	  FILE *f; 
      int koordinatD[200], i = 0, j = 0;
	  int N=0; 
      f = fopen("koordinat.txt", "r"); 
      while(!feof(f)) 
      {
	  fscanf(f, "%d", &koordinatD[i++]); //Koordinatlar� diziye att�k.
	  } 
	  fclose(f);
	  
	  
	  N=i/2;//Nokta say�s�(sat�r say�s�) bulundu.
	  
	  		//Matrise koordinatlar at�l�yor.
   			int koordinatM[N][2];
			   int k=0;
			   for(int i=0;i<N;i++){
			   	for(int j=0;j<2;j++)
				   {
				   	 koordinatM[i][j]=koordinatD[k];
						k++;
					} 
						}
						

		int surucu = DETECT, grmod, hata_kodu; /* DETECT grafik s�r�c�s�n� otomatik se�er */				
   
		          initgraph(&surucu, &grmod, "");       /* grafik ekran�n� ba�lat */ 
		
          hata_kodu = graphresult();            /* hata_kodu al  */
          if (hata_kodu != grOk)                /* hata_kodu 0 dan farkl� ise ba�latma */
          {
            puts("Hata olustu.");
            puts("Grafik ekrani baslatilamiyor.");
            exit(1);
          }
          	//Noktalari siraladik.
         	sirala(koordinatM,N);
         	
         	//x,y koordinat sistemi olu�turuldu.( 0.0 noktas� sol �st k��e al�nm��t�r.pencere boyutu 640/480 al�nm��t�r.)
         	setcolor(WHITE);
         	line(0,240,640,240);
            line(320,0,320,480);
            
            //noktalar koordinat sistemine yerle�tirildi.
            for(i=0;i<N;i++)
            	putpixel(koordinatM[i][0],koordinatM[i][1],YELLOW);
				
				kucuk_cember(koordinatM,N);
				egri(koordinatM,N);
					
          getch();
          closegraph();  

      return 0; 
  } 

  

