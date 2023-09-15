// Pines para los botones
#define LeftPin 2
#define RightPin 5
#define UpPin 4
#define DownPin 3
#define SelectPin 6

// Variables para valor de los botones
int leftValue;
int rightValue;
int upValue;
int downValue;
int selectValue;

// Variable para enviar valores de los botones en un solo número
int digest;

void setup()
{
  // Empieza Serial a un bitrate de 9600 b/s
  Serial.begin(9600);
  
  // Pone los pines de los botones en modo entrada
  pinMode(LeftPin, INPUT);
  pinMode(RightPin, INPUT);
  pinMode(UpPin, INPUT);
  pinMode(DownPin, INPUT);
  pinMode(SelectPin, INPUT);
}

void loop()
{
  // Lee los pines de los botones
  leftValue = digitalRead(LeftPin);
  rightValue = digitalRead(RightPin);
  upValue = digitalRead(UpPin);
  downValue = digitalRead(DownPin);
  selectValue = digitalRead(SelectPin);
  
  // Envía los valores de los botones al monitor serial para uso en el programa
  digest = selectValue + downValue * 0b10 + upValue * 0b100 + rightValue * 0b1000 + leftValue * 0b10000;
  Serial.print(digest);
  Serial.print("\n");
  
  /*
  // Imprime valores de manera más legible
  Serial.print("   ");
  Serial.print(upValue);
  Serial.print("\n");
  Serial.print(leftValue);
  Serial.print("     ");
  Serial.print(rightValue);
  Serial.print("       ");
  Serial.print(selectValue);
  Serial.print("\n   ");
  Serial.print(downValue);
  Serial.print("\n\n");
  */
}
