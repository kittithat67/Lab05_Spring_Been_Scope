# Coffee Menu Service API


## วิธีรันโปรเจกต์

เปิด Terminal ในโฟลเดอร์โปรเจกต์ แล้วรัน:

```powershell
mvn spring-boot:run
```

## ข้อมูลเริ่มต้น

เมื่อเปิดโปรแกรม จะมีเมนูเริ่มต้น 2 รายการ:

```json
[
  { "id": 1, "name": "Espresso", "price": 45.0 },
  { "id": 2, "name": "Latte", "price": 55.0 }
]
```

## API Endpoints

### 1. ดูเมนูกาแฟทั้งหมด

**Method:** `GET`  
**URL:** `/coffees`

```powershell
curl.exe http://localhost:8080/coffees
```


### 2. ดูเมนูกาแฟตาม id

**Method:** `GET`  
**URL:** `/coffees/{id}`

```powershell
curl.exe http://localhost:8080/coffees/1
```



### 3. เพิ่มเมนูกาแฟ

**Method:** `POST`  
**URL:** `/coffees`

```powershell
$body = @{
  name = "Cappuccino"
  price = 60.0
} | ConvertTo-Json

Invoke-RestMethod `
  -Method POST `
  -Uri "http://localhost:8080/coffees" `
  -ContentType "application/json" `
  -Body $body
```

```json
{
  "id": 3,
  "name": "Cappuccino",
  "price": 60.0
}
```

### 4. แก้ไขเมนูกาแฟ

**Method:** `PUT`  
**URL:** `/coffees/{id}`

```powershell
$body = @{
  name = "Latte"
  price = 50.0
} | ConvertTo-Json

Invoke-RestMethod `
  -Method PUT `
  -Uri "http://localhost:8080/coffees/2" `
  -ContentType "application/json" `
  -Body $body
```

### 5. ลบเมนูกาแฟ

**Method:** `DELETE`  
**URL:** `/coffees/{id}`

```powershell
curl.exe -i -X DELETE http://localhost:8080/coffees/3
```


### 6. กรณี 404

กรณี ไม่มี id ที่ต้องการ
```powershell
curl.exe -i http://localhost:8080/coffees/999
```



