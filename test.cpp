

#include <iostream>
#include <string>


using namespace std;

int main(){

	int x = 13;
	int * p = &x;
	*p = 16;
	
	cout << x << endl;
	cout << x << endl;
	cout << &p << endl;
	cout << p << endl;
	

	
	string c = string("12345");
	
	string b("12345");
	
	string * d = new string("12345");
	
	cout << c << endl;
	
	cout << b << endl;
	
	cout << d << endl;
	
	cout << *d << endl;
	
	
	
}


