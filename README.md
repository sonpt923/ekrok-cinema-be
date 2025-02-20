![Image](https://pub-5dc338acc7cf42689f4a62568c3ea41b.r2.dev/logo.png)

# EKROK-CINEMA

## I, service

### 1, Discount service

- **Datebase**: Mysql
- **Description**:  Đây là service quản lý thông tin về các rạp chiếu phim. Các chức năng của service này có thể bao gồm
  quản lý thông tin về các rạp chiếu phim, lịch chiếu, thông tin về các phòng chiếu, giá vé, và các dịch vụ khác liên
  quan đến quản lý các rạp chiếu phim

## 2, Movie service

- **Datebase**: MongoDB
- **Description**: Xử lý phát video

## 3, Notification service

- **Datebase**: MongoDB
- **Description**: Service này quản lý thông báo trong hệ thống.
  Nhiệm vụ của service này bao gồm gửi thông báo tới người dùng khi có sự kiện quan trọng xảy ra trong hệ thống,
  và quản lý cài đặt thông báo của người dùng

## 4, Payment service

- **Datebase**: Mysql
- **Description**: Service này quản lý thông tin người dùng trong hệ thống. Nhiệm vụ của service này có thể bao gồm đăng
  ký người dùng, quản lý thông tin cá nhân, xác thực người dùng, quản lý vai trò và quyền hạn của người dùng, và các
  chức năng liên quan đến quản lý tài khoản người dùng.

## 5, Recommendation service

- **Datebase**: Elasticsearch
- **Description**: sử dụng để gợi ý các loại phim sẽ hiển thị cho người dùng

## 6, Streaming service

- **database**: AWS S3
- **description**: xử lý các thông tin, định dạng, video...

## 7, Subscription service

- **database**: Mysql
- **description**: xử lý việc thanh toán (trực tiếp, ngân hàng, ví thanh toán đện tử...)

## 8, User service

- **database**: Mysql
- **description**: Lưu thông tin của người dùng, loại tài khoản, thông tin tài khoản, 


## 8, Schedule service

- **database**: Mysql
- **description**: Lưu lại tác động của các công việc đã được lên lịch


# II, Công nghệ

## 1, Database

- RDMS:
    - mysql:

- NoSql:
    - MongoDB:
    - Redis:

## 2, spring boot

- JWT, security, oauth2
- JPA,
- Log4j
- UnitTesting

## 3, cloud

- **AWS**:
    - RDS: sử dụng để làm cơ ở dữ liệu ...
    - EC2: su dụng để ...
    - S3 Bucket (cloudflare): lưu tru du lieu (file, video...)

## 4, Message Queue

- **Kafka**:

## 5, Docker

- docker image
- docker file
- docker compose
- docker network

## 6, Orther

# III, 
 
# V,

- draw.io: https://app.diagrams.net/#G1D8ayGQ-tIOHoZhpv60E1_BywWRZHdryd#%7B%22pageId%22%3A%22pxJnE2IzepgIanvHQNzt%22%7D
