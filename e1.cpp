#include <iostream>
#include <string>
using namespace std;
template <class T>
class TArray_max
{ 
public:      
	TArray_max(int n)	//���캯��
	{
		num=n;				//����Ԫ�ظ���
		array=new T[num];	//��̬��������ռ�
		if(array==NULL)		//������ɹ���
		{
			cout<<"����ʧ��"<<endl;
			exit(1);
		}
	}
	~TArray_max()		//��������
	{
		delete[] array;		//�ͷſռ�
	}
	void SetValue();	//Ϊ������������
    void GetMax();	//�����Ԫ��   
    void ShowMax();	//��ʾ���Ԫ��
private:
	T *array;	//����ռ��׵�ַ
	int num;	//Ԫ�ظ���
	T max;		//���Ԫ��
};
template <class T>
void TArray_max<T>::SetValue( )
{
	cout<<"������"<<num<<"������"<<endl;
    for (int i=0;i<num;i++)
		cin>>array[i];  
}
template <class T>
void TArray_max<T>::GetMax( )      
{
    max=array[0];
    for(int i=1;i<num;i++)
		if(array[i]>max) 
			max=array[i];
}
template <class T>
void TArray_max<T>::ShowMax( )    
{
	cout<<"max="<<max<<endl;
}

int main( )
{ 
	int n;
	cout<<"���������ݸ�����";
	cin>>n;

	cout<<"�������У�"<<endl;
	TArray_max<int> a(n);	//��������a   
	a.SetValue();		//��������
	a.GetMax();		//�������Ԫ��
	a.ShowMax();		//��ʾ���Ԫ��

	cout<<"�ַ������У�"<<endl;
	TArray_max<string> b(n);//��������b   
	b.SetValue();		//��������
	b.GetMax();		//�������Ԫ��
	b.ShowMax();		//��ʾ���Ԫ��
	return 0;
}