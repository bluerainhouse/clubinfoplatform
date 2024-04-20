# 第一週使用說明
* 直接clone下來，並且在我回來前能啟起來就好
* Java版本為17，我之前是用8開發的，但不知道為甚麼今天就是開不起來，換17就沒事了
* 依照之前助教課的教學導入專案、有問題就```maven update project```、```build/clean```、```rebuild```，或是求救ChatGPT
* 設定連線資訊(在mysql建立相同名稱的資料庫)、在```application.properties```更改成你的使用者名稱還有密碼
# 開發使用說明
* 我的專案其實結構都已經完整了，有關JWT、驗證、安全性的東西不要動到就好
* 開發請遵照entity>dao>service>controller的順序
* SQL相關寫在DAO，**邏輯不要寫在DAO**
* 邏輯寫在service
* controller只負責處理進來的東西，其他東西丟給service做，**邏輯不要寫在controller**
