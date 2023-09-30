const int upButtonPin = 10;
const int downButtonPin = 6;
const int rightButtonPin = 4;
const int leftButtonPin = 2;
const int selectButtonPin = 8;

void setup() {
  pinMode(upButtonPin, INPUT_PULLUP);
  pinMode(downButtonPin, INPUT_PULLUP);
  pinMode(rightButtonPin, INPUT_PULLUP);
  pinMode(leftButtonPin, INPUT_PULLUP);
  pinMode(selectButtonPin, INPUT_PULLUP);
  
  Serial.begin(9600);
}

void loop() {
  if (digitalRead(upButtonPin) == LOW) {
    Serial.write('U');
  }
  if (digitalRead(downButtonPin) == LOW) {
    Serial.write('D');
  }
  if (digitalRead(rightButtonPin) == LOW) {
    Serial.write('R');
  }
  if (digitalRead(leftButtonPin) == LOW) {
    Serial.write('L');
  }
  if (digitalRead(selectButtonPin) == LOW) {
    Serial.write('S');
  }
  
  delay(100);
}