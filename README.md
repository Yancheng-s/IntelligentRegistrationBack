# 智能医院挂号系统后端

本项目是「智能医院挂号系统」的后端，提供完整的医院挂号流程管理、科室医生信息管理、用户登录注册以及AI智能导诊等功能。

智能挂号项目分别放在三个代码仓库：

1.用户端网页代码仓库： https://github.com/Yancheng-s/IntelligentRegistrationUserFront

2.管理员端网页代码仓库： https://github.com/Yancheng-s/IntelligentRegistrationAdminFront

3.后端代码仓库： https://github.com/Yancheng-s/IntelligentRegistrationBack

## 功能特性

- **智能导诊**：集成AI聊天机器人，提供智能问诊建议
- **用户管理**：支持用户注册、登录及信息更新
- **挂号管理**：完整的挂号流程管理，包括预约、查询、退号等功能
- **科室管理**：支持科室信息的增删改查操作
- **医生管理**：管理医生排班信息及挂号级别
- **就诊记录**：记录患者就诊信息并支持查询
- **治疗组管理**：支持治疗组的创建和管理

## 主要模块

- **HospitalGuide**：AI智能导诊模块，使用阿里云大模型进行智能对话
- **Login**：用户和医生登录验证模块
- **Department**：科室信息管理模块
- **Employee**：医生信息及排班管理模块
- **Register**：挂号预约核心模块
- **TreatmentGroups**：治疗组管理模块

## 技术栈

- Spring Boot
- MyBatis
- MySQL
- RESTful API
- 阿里云大模型（AI智能导诊）

## API文档

### 登录相关

- `POST /login`：医生登录
- `POST /api/FirstLogin`：用户首次登录
- `POST /api/UserLogin`：用户登录
- `POST /api/UpdateUserInfo`：更新用户信息

### 科室管理

- `GET /getAllDeptList`：获取所有科室列表
- `GET /getDeptListByPage`：分页查询科室列表
- `POST /addDepartment`：添加科室
- `PUT /updateDepartment`：更新科室信息
- `DELETE /deleteDepartment/{deptCode}`：删除科室

### 医生管理

- `GET /getRegistDoctorList`：获取挂号医生列表
- `GET /getDoctorListWithRegistName`：获取带挂号名称的医生列表

### 挂号管理

- `POST /addRegister`：添加挂号记录
- `GET /getMaxCaseNumber`：获取最大病例编号
- `GET /getAlreadyRegisterCount`：获取已挂号人数
- `POST /getAlreadyRegisterPatients`：获取已挂号患者列表
- `GET /getTodayRegisterRecords`：获取今日挂号记录
- `GET /getRegisterList`：获取挂号列表（支持条件查询）

### 治疗组管理

- `POST /api/treatment-groups/add`：添加治疗组
- `GET /api/treatment-groups/{id}`：获取治疗组详情
- `GET /api/treatment-groups/by-name/{realName}`：根据患者姓名获取治疗组
- `DELETE /api/treatment-groups/delete-by-name/{treatmentName}`：根据治疗名称删除治疗组

### 智能导诊

- `POST /api/hospitalGuide/chat`：与AI导诊机器人聊天

## 数据库设计

项目使用MySQL数据库，主要表包括：

- `department`：科室信息表
- `employee`：医生信息表
- `register`：挂号记录表
- `treatment_groups`：治疗组信息表

## 部署说明

1. 安装MySQL数据库并创建相应表结构
2. 修改`application.properties`中的数据库连接信息
3. 执行Maven构建：`mvn clean package`
4. 运行项目：`java -jar hospital-registration-backend.jar`

## 贡献指南

欢迎贡献代码！请遵循以下步骤：

1. Fork项目
2. 创建新分支
3. 提交代码更改
4. 创建Pull Request

## 许可证

本项目采用MIT许可证。详情请参阅LICENSE文件。
