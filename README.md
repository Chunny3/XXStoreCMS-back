# XXStoreCMS
#### 這是一個使用 Spring Boot 和 ReactJS 的產品管理系統，為網路商店管理員所設計的網頁，可以使用新增、修改和刪除來調整商品。

![image](https://github.com/Chunny3/XXStoreCMS-front/blob/main/AddProduct.jpg)

## 安裝
### 專案技術 & 資料庫
- Spring Boot
- Lombok
- MySQL

### 取得專案
```
git clone git@github.com:Chunny3/XXStoreCMS-back.git
```
### 移動到專案內
```
cd XXStoreCMS-back
```
### 安裝套件
```
mvn install
```
### 運行後端服務
```
mvn spring-boot:run
```
### 配置資料庫 (MySQL)
> 在 application.properties 中設置資料庫連接資料
- spring.datasource.url = jdbc:mysql://localhost:3306/`your_database`
- spring.datasource.username = `your_username`
- spring.datasource.password = `your_password`


## Web API服務
### 使用 Postman 測試 API
獲取所有產品 (GET)
1. 創建一個新的 GET 請求
2. 設置請求 URL 
```
http://localhost:8080/api/products
```
3. 回傳的 JSON 內容
    
```
[
    {
        "pid": 1,
        "name": "phone",
        "price": 100.0,
        "introduce": "It's a phone"
    }
]
```
***

創建新產品 (POST)
1. 創建一個新的 POST 請求
2. 設置請求 URL
```
http://localhost:8080/api/add_product
```
3. 在 Body 標籤中，選擇 raw 和 JSON 格式，並添加 JSON 數據
```
{
    "name": "computer",
    "price": 10000.0,
    "introduce": "It's a computer"
}
```
4. 回傳的 JSON 內容
```
{
    "pid": 2,
    "name": "computer",
    "price": 10000.0,
    "introduce": "It's a computer"
}
```
***

更新產品 (PUT)
1. 創建一個新的 PUT 請求
2. 設置請求 URL
```
http://localhost:8080/api/update_product/2
```
3. 在 Body 標籤中，選擇 raw 和 JSON 格式，並添加 JSON 數據
```
{
    "name": "USB",
    "price": 100.0,
    "introduce": "It's a USB"
}
```
4. 回傳的 JSON 內容
```
    {
        "pid": 2,
        "name": "USB",
        "price": 100.0,
        "introduce": "It's a USB"
    }
```
***

刪除商品
1. 創建一個新的 DELETE 請求
2. 設置請求 URL
```
http://localhost:8080/api/delete_product/2
```
3. 回傳的 JSON 內容
```
Status: 200 OK
```
