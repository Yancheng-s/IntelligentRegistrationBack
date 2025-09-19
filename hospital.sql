/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3307
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3307
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 18/08/2025 18:05:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `dept_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室编码',
  `dept_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名称',
  `dept_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室类型（门诊、检查、检验、处置）',
  `delmark` int(11) NULL DEFAULT 1 COMMENT '生效标记',
  `doctor_id` int(11) NULL DEFAULT NULL COMMENT '医生id',
  `strong_point` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 146 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 'XXGNK', '心血管内科', '门诊', 1, 1, '擅长冠心病支架植入、心律失常射频消融及心衰管理。');
INSERT INTO `department` VALUES (2, 'SJNK', '神经内科', '门诊', 1, 2, '专治脑梗死溶栓、帕金森病及癫痫规范化诊疗。');
INSERT INTO `department` VALUES (3, 'PTNK', '普通内科', '门诊', 1, 3, '精通胃肠镜早癌筛查、肝硬化门脉高压综合治疗。');
INSERT INTO `department` VALUES (4, 'XHNK', '消化内科', '门诊', 1, 4, '专注慢阻肺、哮喘及肺部结节精准鉴别诊断。');
INSERT INTO `department` VALUES (5, 'HXNK', '呼吸内科', '门诊', 1, 5, '糖尿病胰岛素泵调控、甲状腺结节细针穿刺专家。');
INSERT INTO `department` VALUES (6, 'NFMK', '内分泌科', '门诊', 1, 6, '糖尿病胰岛素泵调控、甲状腺结节细针穿刺专家。');
INSERT INTO `department` VALUES (7, 'SBNK', '肾病内科', '门诊', 1, 7, '擅长血液透析通路建立、慢性肾病一体化管理。');
INSERT INTO `department` VALUES (8, 'XYNK', '血液内科', '门诊', 1, 8, '白血病化疗、淋巴瘤靶向治疗及骨髓移植术。');
INSERT INTO `department` VALUES (9, 'GRNK', '感染内科', '门诊', 1, 9, '疑难发热病因排查、艾滋病及肝病抗病毒治疗。');
INSERT INTO `department` VALUES (10, 'LNBNK', '老年病内科', '门诊', 1, 10, '老年多病共存患者用药优化及功能康复指导。');
INSERT INTO `department` VALUES (11, 'FSMYNK', '风湿免疫内科', '门诊', 1, 11, '类风湿关节炎生物制剂治疗、痛风规范化管理。');
INSERT INTO `department` VALUES (12, 'TXK', '透析科', '处置', 1, 12, '长期透析患者并发症防治及血管通路维护专家。');
INSERT INTO `department` VALUES (13, 'BTFYK', '变态反应科', NULL, 1, 13, '过敏性鼻炎脱敏治疗、重症哮喘生物靶向干预。');
INSERT INTO `department` VALUES (14, 'PTWK', '普通外科', '门诊', 1, 14, '腹腔镜胆囊/阑尾切除、腹股沟疝无张力修补术。');
INSERT INTO `department` VALUES (15, 'MNWK', '泌尿外科', '门诊', 1, 15, '前列腺增生绿激光手术、输尿管软镜碎石取石。');
INSERT INTO `department` VALUES (16, 'SJWK', '神经外科', '门诊', 1, 16, '脑胶质瘤显微切除、三叉神经痛微血管减压术。');
INSERT INTO `department` VALUES (17, 'XWK', '胸外科', '门诊', 1, 17, '肺癌胸腔镜肺叶切除、食管癌根治术经验丰富。');
INSERT INTO `department` VALUES (18, 'ZXWK', '整形外科', '门诊', 1, 18, '眼鼻综合整形、瘢痕修复及乳房再造专家。');
INSERT INTO `department` VALUES (19, 'GCWK', '肛肠外科', '门诊', 1, 19, '痔疮PPH术、直肠癌保肛手术及肛周脓肿根治。');
INSERT INTO `department` VALUES (20, 'GDWK', '肝胆外科', '门诊', 1, 20, '肝癌精准肝切除、胆道结石ERCP微创取石。');
INSERT INTO `department` VALUES (21, 'RXWK', '乳腺外科', '门诊', 1, 21, '乳腺癌保乳手术、前哨淋巴结活检技术领先。');
INSERT INTO `department` VALUES (22, 'XXGWK', '心血管外科', '门诊', 1, 22, '主动脉夹层全弓置换、瓣膜成形术经验丰富。');
INSERT INTO `department` VALUES (23, 'XZWK', '心脏外科', '门诊', 1, 23, '先心病微创封堵、冠脉搭桥手术成功率极高。');
INSERT INTO `department` VALUES (24, 'QGYZ', '器官移植', '', 1, 24, '肾移植围术期管理及免疫抑制剂个体化调整。');
INSERT INTO `department` VALUES (25, 'WCWK', '微创外科', NULL, 1, 25, '单孔腹腔镜手术、减重代谢手术并发症防治。');
INSERT INTO `department` VALUES (26, 'GNSJWK', '功能神经外科', NULL, 1, 26, '帕金森病脑深部电刺激术（DBS）、癫痫灶精准定位专家。');
INSERT INTO `department` VALUES (27, 'XTWK', '腺体外科', NULL, 1, 27, '甲状腺癌根治术、甲状旁腺功能亢进微创手术。');
INSERT INTO `department` VALUES (28, 'EKZH', '儿科综合', '门诊', 1, 28, '暂无详细描述');
INSERT INTO `department` VALUES (29, 'XEWK', '小儿外科', '门诊', 1, 29, '暂无详细描述');
INSERT INTO `department` VALUES (30, 'ETBJK', '儿童保健科', NULL, 1, 30, '儿童生长发育评估、营养指导及早期发育干预');
INSERT INTO `department` VALUES (31, 'XSEK', '新生儿科', NULL, 1, 31, '暂无详细描述');
INSERT INTO `department` VALUES (32, 'XEGK', '小儿骨科', '门诊', 1, 32, '儿童骨折弹性髓内钉固定、先天性髋关节脱位矫正');
INSERT INTO `department` VALUES (33, 'XESJNK', '小儿神经内科', '门诊', 1, 33, '儿童癫痫精准分型治疗、脑瘫康复管理');
INSERT INTO `department` VALUES (34, 'XEHXK', '小儿呼吸科', '门诊', 1, 34, '儿童哮喘规范化控制、支气管镜肺泡灌洗术');
INSERT INTO `department` VALUES (35, 'XEXYK', '小儿血液科', '门诊', 1, 35, '儿童白血病分层治疗、地中海贫血造血干细胞移植');
INSERT INTO `department` VALUES (36, 'XEEBHK', '小儿耳鼻喉科', '门诊', 1, 36, '儿童鼾症扁桃体切除、先天性耳畸形矫正');
INSERT INTO `department` VALUES (37, 'XEXNK', '小儿心内科', '门诊', 1, 37, '先心病介入封堵术、儿童心肌炎综合治疗');
INSERT INTO `department` VALUES (38, 'XEKFK', '小儿康复科', '门诊', 1, 38, '脑瘫儿童运动功能训练、高压氧康复治疗');
INSERT INTO `department` VALUES (39, 'XEJSK', '小儿精神科', '门诊', 1, 39, '儿童多动症行为干预、自闭症评估诊疗');
INSERT INTO `department` VALUES (40, 'XESNK', '小儿肾内科', '门诊', 1, 1, '儿童肾病综合征个体化激素治疗');
INSERT INTO `department` VALUES (41, 'XEXHK', '小儿消化科', '门诊', 1, 2, '儿童食物过敏管理、慢性腹泻营养治疗');
INSERT INTO `department` VALUES (42, 'XEPFK', '小儿皮肤科', '门诊', 1, 3, '特应性皮炎生物制剂治疗、血管瘤激光疗法');
INSERT INTO `department` VALUES (43, 'XEJZK', '小儿急诊科', '门诊', 1, 4, '儿童重症肺炎抢救、意外中毒应急处理');
INSERT INTO `department` VALUES (44, 'XENFMK', '小儿内分泌科', '门诊', 1, 5, '儿童性早熟抑制治疗、矮小症生长激素应用');
INSERT INTO `department` VALUES (45, 'XEMNWK', '小儿泌尿外科', '门诊', 1, 6, '隐匿阴茎矫正术、肾积水输尿管再植术');
INSERT INTO `department` VALUES (46, 'XEGRK', '小儿感染科', '门诊', 1, 7, 'EB病毒感染综合治疗、手足口病重症救治');
INSERT INTO `department` VALUES (47, 'XEXWK01', '小儿心外科', '门诊', 1, 8, '新生儿先心病急诊手术、室缺微创封堵');
INSERT INTO `department` VALUES (48, 'XEXWK02', '小儿胸外科', '门诊', 1, 9, '先天性食管闭锁重建、纵隔肿瘤切除');
INSERT INTO `department` VALUES (49, 'XESJWK', '小儿神经外科', '门诊', 1, 10, '儿童脑积水V-P分流术、脊髓栓系松解');
INSERT INTO `department` VALUES (50, 'XEZXK', '小儿整形科', '门诊', 1, 11, '小儿烧伤瘢痕修复、先天性唇腭裂序列治疗');
INSERT INTO `department` VALUES (51, 'XEFSMYK', '小儿风湿免疫科', '门诊', 1, 12, '幼年特发性关节炎生物靶向治疗');
INSERT INTO `department` VALUES (52, 'XEFK', '小儿妇科', '门诊', 1, 13, '青春期月经失调调理、外阴发育异常矫正');
INSERT INTO `department` VALUES (53, 'CRK', '传染科', '门诊', 1, 14, '霍乱/炭疽等烈性传染病隔离治疗专家');
INSERT INTO `department` VALUES (54, 'GBK', '肝病科', '门诊', 1, 15, '乙肝抗病毒优化治疗、肝硬化并发症防治');
INSERT INTO `department` VALUES (55, 'AZBK', '艾滋病科', '', 1, 16, 'HIV暴露后预防（PEP）、机会性感染控制');
INSERT INTO `department` VALUES (56, 'CRWZS', '传染危重室', '', 1, 17, '重症禽流感ECMO治疗、脓毒症抢救');
INSERT INTO `department` VALUES (57, 'FCKZH', '妇产科综合', NULL, 1, 18, '暂无详细描述');
INSERT INTO `department` VALUES (58, 'FK', '妇科', '门诊', 1, 19, '暂无详细描述');
INSERT INTO `department` VALUES (59, 'CK', '产科', '门诊', 1, 20, '暂无详细描述');
INSERT INTO `department` VALUES (60, 'JHSYK', '计划生育科', NULL, 1, 21, '高危人流手术、避孕节育咨询指导');
INSERT INTO `department` VALUES (61, 'FKNFM', '妇科内分泌', NULL, 1, 22, '多囊卵巢综合征长期管理、更年期激素治疗');
INSERT INTO `department` VALUES (62, 'YCZYK', '遗传咨询科', NULL, 1, 23, '染色体异常产前诊断、遗传病风险评估');
INSERT INTO `department` VALUES (63, 'CQJCK', '产前检查科', NULL, 1, 24, '胎儿畸形超声筛查、孕期营养监测');
INSERT INTO `department` VALUES (64, 'FMNK', '妇泌尿科', NULL, 1, 25, '女性压力性尿失禁TVT-O吊带术');
INSERT INTO `department` VALUES (65, 'QLX', '前列腺', NULL, 1, 26, '前列腺炎综合治疗、前列腺穿刺活检');
INSERT INTO `department` VALUES (66, 'XGNZA', '性功能障碍', NULL, 1, 27, '勃起功能障碍药物及真空负压治疗');
INSERT INTO `department` VALUES (67, 'SZQGR', '生殖器感染', NULL, 1, 28, '顽固性尿道炎病原体精准检测治疗');
INSERT INTO `department` VALUES (68, 'NXBY', '男性不育', NULL, 1, 29, '精索静脉曲张显微结扎、精子冷冻保存');
INSERT INTO `department` VALUES (69, 'SZZX', '生殖整形', NULL, 1, 30, '隐匿阴茎延长术、包皮整形美容修复');
INSERT INTO `department` VALUES (70, 'JSK', '精神科', '门诊', 1, 31, '精神伤残等级评估、刑事责任能力鉴定');
INSERT INTO `department` VALUES (71, 'SFJDK', '司法鉴定科', NULL, 1, 32, '酒精成瘾替代治疗、戒毒康复管理');
INSERT INTO `department` VALUES (72, 'YWYLK', '药物依赖科', '门诊', 1, 33, '精神伤残等级评估、刑事责任能力鉴定');
INSERT INTO `department` VALUES (73, 'ZYJSK', '中医精神科', '门诊', 1, 34, '焦虑症中药调理、失眠针灸疗法');
INSERT INTO `department` VALUES (74, 'SXZAK', '双相障碍科', NULL, 1, 35, '躁郁症情绪稳定剂个体化用药');
INSERT INTO `department` VALUES (75, 'PFK', '皮肤科', '门诊', 1, 36, '暂无详细描述');
INSERT INTO `department` VALUES (76, 'XBK', '性病科', NULL, 1, 37, '暂无详细描述');
INSERT INTO `department` VALUES (77, 'ZYZHK', '中医综合科', NULL, 1, 38, '暂无详细描述');
INSERT INTO `department` VALUES (78, 'ZJK', '针灸科', '处置', 1, 39, '暂无详细描述');
INSERT INTO `department` VALUES (79, 'ZYGK', '中医骨科', '门诊', 1, 1, '骨折手法复位、腰椎间盘突出中药熏蒸');
INSERT INTO `department` VALUES (80, 'ZYFCK', '中医妇产科', '门诊', 1, 2, '不孕症周期调理、产后中药发汗');
INSERT INTO `department` VALUES (81, 'ZYWK', '中医外科', '门诊', 1, 3, '疮疡祛腐生肌疗法、糖尿病足外敷');
INSERT INTO `department` VALUES (82, 'ZYEK', '中医儿科', '门诊', 1, 4, '小儿积食推拿、反复感冒膏方调理');
INSERT INTO `department` VALUES (83, 'ZYGCK', '中医肛肠科', '门诊', 1, 5, '痔疮结扎疗法、肛裂中药坐浴');
INSERT INTO `department` VALUES (84, 'ZYPFK', '中医皮肤科', '门诊', 1, 6, '过敏性鼻炎穴位敷贴、耳鸣针灸');
INSERT INTO `department` VALUES (85, 'ZYWGK', '中医五官科', '门诊', 1, 7, '颈椎病手法正骨、肩周炎经络推拿');
INSERT INTO `department` VALUES (86, 'ZYAMK', '中医按摩科', '门诊', 1, 8, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (87, 'ZYXHK', '中医消化科', '门诊', 1, 9, '少弱精症补肾疗法、前列腺按摩');
INSERT INTO `department` VALUES (88, 'ZYZLK', '中医肿瘤科', '门诊', 1, 10, '三维适形精准放疗、放射性肺炎防治');
INSERT INTO `department` VALUES (89, 'ZYXNK', '中医心内科', '门诊', 1, 11, '宫颈癌同步放化疗、卵巢癌减灭术');
INSERT INTO `department` VALUES (90, 'ZYSJNK', '中医神经内科', '门诊', 1, 12, '骨肉瘤保肢手术、转移瘤射频消融');
INSERT INTO `department` VALUES (91, 'ZYSBNK', '中医肾病内科', '门诊', 1, 13, '癌因性疲乏中医调理、淋巴水肿引流');
INSERT INTO `department` VALUES (92, 'ZYNFM', '中医内分泌', '门诊', 1, 14, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (93, 'ZYHXK', '中医呼吸科', '门诊', 1, 15, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (94, 'ZYGBK', '中医肝病科', '门诊', 1, 16, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (95, 'ZYNK', '中医男科', NULL, 1, 17, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (96, 'ZYFSMYNK', '中医风湿免疫内科', NULL, 1, 18, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (97, 'ZYXYK', '中医血液科', '门诊', 1, 19, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (98, 'ZYRXWK', '中医乳腺外科', '门诊', 1, 20, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (99, 'ZYLNBK', '中医老年病科', '门诊', 1, 21, '乙肝抗纤维化中药、脂肪肝茶饮');
INSERT INTO `department` VALUES (100, 'ZLZHK', '肿瘤综合科', '门诊', 1, 22, '骨肉瘤保肢手术、转移瘤射频消融');
INSERT INTO `department` VALUES (101, 'ZLNK', '肿瘤内科', '门诊', 1, 23, '骨肉瘤保肢手术、转移瘤射频消融');
INSERT INTO `department` VALUES (102, 'FLK', '放疗科', '处置', 1, 24, '骨肉瘤保肢手术、转移瘤射频消融');
INSERT INTO `department` VALUES (103, 'ZLWK', '肿瘤外科', NULL, 1, 25, '骨肉瘤保肢手术、转移瘤射频消融');
INSERT INTO `department` VALUES (104, 'ZLFK', '肿瘤妇科', NULL, 1, 26, '宫颈癌同步放化疗、卵巢癌减灭术');
INSERT INTO `department` VALUES (105, 'GZLK', '骨肿瘤科', NULL, 1, 27, '骨肉瘤保肢手术、转移瘤射频消融');
INSERT INTO `department` VALUES (106, 'ZLKFK', '肿瘤康复科', '处置', 1, 28, '癌因性疲乏中医调理、淋巴水肿引流');
INSERT INTO `department` VALUES (107, 'GWK', '骨外科', NULL, 1, 29, '癌因性疲乏中医调理、淋巴水肿引流');
INSERT INTO `department` VALUES (108, 'SWK', '手外科', NULL, 1, 30, '断指再植显微手术、腕管综合征松解');
INSERT INTO `department` VALUES (109, 'CSGK', '创伤骨科', NULL, 1, 31, '复杂骨盆骨折复位、骨髓炎骨搬运');
INSERT INTO `department` VALUES (110, 'JZWK', '脊柱外科', NULL, 1, 32, '颈椎病前路减压、脊柱侧弯矫形钉棒');
INSERT INTO `department` VALUES (111, 'GGJK', '骨关节科', NULL, 1, 33, '半月板缝合术、关节软骨移植修复');
INSERT INTO `department` VALUES (112, 'GZSSK', '骨质疏松科', NULL, 1, 34, '脆性骨折椎体成形、骨代谢调节');
INSERT INTO `department` VALUES (113, 'JXGK', '矫形骨科', NULL, 1, 35, '马蹄内翻足矫正、肢体延长术');
INSERT INTO `department` VALUES (114, 'EBYHTJK', '耳鼻咽喉头颈科', NULL, 1, 36, '暂无详细描述');
INSERT INTO `department` VALUES (115, 'KQK', '口腔科', NULL, 1, 37, '暂无详细描述');
INSERT INTO `department` VALUES (116, 'YK', '眼科', NULL, 1, 38, '暂无详细描述');
INSERT INTO `department` VALUES (117, 'KFK', '康复科', '处置', 1, 39, '暂无详细描述');
INSERT INTO `department` VALUES (118, 'LLK', '理疗科', '处置', 1, 1, '暂无详细描述');
INSERT INTO `department` VALUES (119, 'MZK', '麻醉科', NULL, 1, 2, '暂无详细描述');
INSERT INTO `department` VALUES (120, 'TTK', '疼痛科', NULL, 1, 3, '暂无详细描述');
INSERT INTO `department` VALUES (121, 'YYK', '营养科', NULL, 1, 4, '暂无详细描述');
INSERT INTO `department` VALUES (122, 'GYYK', '高压氧科', NULL, 1, 5, '暂无详细描述');
INSERT INTO `department` VALUES (123, 'GNJCK', '功能检查科', NULL, 1, 6, '暂无详细描述');
INSERT INTO `department` VALUES (124, 'BLK', '病理科', '检验', 1, 7, '暂无详细描述');
INSERT INTO `department` VALUES (125, 'JYK', '检验科', '检验', 1, 8, '暂无详细描述');
INSERT INTO `department` VALUES (126, 'SYZX', '实验中心', '检验', 1, 9, '暂无详细描述');
INSERT INTO `department` VALUES (127, 'XDTK', '心电图科', '检查', 1, 10, '暂无详细描述');
INSERT INTO `department` VALUES (128, 'FSK', '放射科', '检查', 1, 11, '暂无详细描述');
INSERT INTO `department` VALUES (129, 'CSZDK', '超声诊断科', '检查', 1, 12, '暂无详细描述');
INSERT INTO `department` VALUES (130, 'YXYXK', '医学影像科', '检查', 1, 13, '暂无详细描述');
INSERT INTO `department` VALUES (131, 'HYK', '核医学科', NULL, 1, 14, '暂无详细描述');
INSERT INTO `department` VALUES (132, 'YJK', '药剂科', NULL, 1, 15, '暂无详细描述');
INSERT INTO `department` VALUES (133, 'HLK', '护理科', '处置', 1, 16, '暂无详细描述');
INSERT INTO `department` VALUES (134, 'TJK', '体检科', '检查', 1, 17, '暂无详细描述');
INSERT INTO `department` VALUES (135, 'JZK', '急诊科', NULL, 1, 18, '暂无详细描述');
INSERT INTO `department` VALUES (136, 'GGWSYYFK', '公共卫生与预防科', '防疫', 1, 19, '暂无详细描述');
INSERT INTO `department` VALUES (137, 'SBK', '设备科', '设备', 1, 20, '暂无详细描述');
INSERT INTO `department` VALUES (138, 'CWK', '财务科', '财务', 1, 21, '暂无详细描述');
INSERT INTO `department` VALUES (139, 'YPK', '药品管理科', '药房', 1, 22, '暂无详细描述');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `realname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `deptment_id` int(11) NULL DEFAULT NULL COMMENT '所在科室ID',
  `regist_level_id` int(11) NULL DEFAULT 1 COMMENT '挂号级别ID',
  `scheduling_id` int(11) NULL DEFAULT 1 COMMENT '班排id',
  `delmark` int(11) NULL DEFAULT 1 COMMENT '生效标记',
  `num` int(50) NULL DEFAULT NULL COMMENT '历史预约人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '扁鹊', '123', 1, 1, 5, 1, 364);
INSERT INTO `employee` VALUES (2, '范无病', '123', 1, 2, 3, 1, 512);
INSERT INTO `employee` VALUES (3, '霍去病', '123', 1, 2, 4, 1, 651);
INSERT INTO `employee` VALUES (4, '华佗', '123', 2, 1, 2, 1, 654);
INSERT INTO `employee` VALUES (5, '葛洪', '123', 2, 2, 1, 1, 678);
INSERT INTO `employee` VALUES (6, '安道全', '123', 2, 2, 2, 1, 368);
INSERT INTO `employee` VALUES (7, '孙思邈', '123', 2, 2, 1, 1, 353);
INSERT INTO `employee` VALUES (8, '张仲景', '123', 1, 1, 3, 1, 854);
INSERT INTO `employee` VALUES (9, '皇甫谧', '123', 2, 3, 4, 1, 462);
INSERT INTO `employee` VALUES (10, '叶桂', '123', 2, 3, 5, 1, 864);
INSERT INTO `employee` VALUES (11, '薛生白', '123', 1, 1, 1, 1, 426);
INSERT INTO `employee` VALUES (12, '宋慈', '123', 1, 2, 2, 1, 967);
INSERT INTO `employee` VALUES (13, '王叔和', '123', 1, 3, 3, 1, 642);
INSERT INTO `employee` VALUES (14, '彭万里', '123', 128, 1, 4, 1, 252);
INSERT INTO `employee` VALUES (15, '高大山', '123', 129, 2, 5, 1, 463);
INSERT INTO `employee` VALUES (16, '谢大海', '123', 128, 3, 1, 1, 146);
INSERT INTO `employee` VALUES (17, '马宏宇', '123', 129, 2, 2, 1, 373);
INSERT INTO `employee` VALUES (18, '林莽', '123', 129, 1, 3, 1, 256);
INSERT INTO `employee` VALUES (19, '黄强辉', '123', 129, 3, 4, 1, 547);
INSERT INTO `employee` VALUES (20, '章汉武', '123', 129, 1, 5, 1, 865);
INSERT INTO `employee` VALUES (21, '范长江', '123', 128, 2, 1, 1, 531);
INSERT INTO `employee` VALUES (22, '林君雄', '123', 128, 3, 2, 1, 653);
INSERT INTO `employee` VALUES (23, '谭平山', '123', 127, 2, 3, 1, 674);
INSERT INTO `employee` VALUES (24, '朱希亮', '123', 127, 1, 4, 1, 462);
INSERT INTO `employee` VALUES (25, '甘铁生', '123', 134, 3, 5, 1, 543);
INSERT INTO `employee` VALUES (26, '马继祖', '123', 134, 1, 1, 1, 153);
INSERT INTO `employee` VALUES (27, '程孝先', '123', 127, 2, 2, 1, 64);
INSERT INTO `employee` VALUES (28, '宗敬先', '123', 130, 3, 3, 1, 785);
INSERT INTO `employee` VALUES (29, '吕显祖', '123', 118, 1, 4, 1, 542);
INSERT INTO `employee` VALUES (30, '何光宗', '123', 117, 2, 5, 1, 746);
INSERT INTO `employee` VALUES (31, '孙念祖', '123', 124, 3, 1, 1, 643);
INSERT INTO `employee` VALUES (32, '马建国', '123', 126, 2, 2, 1, 523);
INSERT INTO `employee` VALUES (33, '节振国', '123', 125, 1, 3, 1, 687);
INSERT INTO `employee` VALUES (34, '冯兴国', '123', 124, 3, 4, 1, 536);
INSERT INTO `employee` VALUES (35, '张伟', '123', 118, 1, 5, 1, 647);
INSERT INTO `employee` VALUES (36, '王芳', '123', 118, 2, 1, 1, 689);
INSERT INTO `employee` VALUES (37, '李娜', '123', 117, 3, 2, 1, 734);
INSERT INTO `employee` VALUES (38, '李静', '123', 106, 2, 3, 1, 636);
INSERT INTO `employee` VALUES (39, '刘伟', '123', 106, 1, 4, 1, 515);

-- ----------------------------
-- Table structure for regist_level
-- ----------------------------
DROP TABLE IF EXISTS `regist_level`;
CREATE TABLE `regist_level`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `regist_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '号别编码',
  `regist_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '号别名称',
  `regist_fee` decimal(8, 2) NULL DEFAULT NULL COMMENT '挂号费',
  `regist_quota` int(11) NULL DEFAULT NULL COMMENT '挂号限额',
  `sequence_no` int(11) NULL DEFAULT NULL COMMENT '显示顺序号',
  `delmark` int(11) NULL DEFAULT 1 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of regist_level
-- ----------------------------
INSERT INTO `regist_level` VALUES (1, 'zjh', '专家号', 50.00, 20, 1, 1);
INSERT INTO `regist_level` VALUES (2, 'pth', '普通号', 8.00, 30, 2, 1);
INSERT INTO `regist_level` VALUES (3, 'zrysh', '主任医生号', 20.00, 30, 3, 1);

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `case_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病历号',
  `real_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别（男、女）',
  `card_number` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `age_type` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄类型（年、天）',
  `home_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `visit_date` datetime(0) NULL DEFAULT NULL COMMENT '本次看诊日期',
  `noon` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午别（上午、下午）',
  `deptment_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本次挂号科室id',
  `employee_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本次挂号医生id',
  `regist_level_id` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本次挂号级别id',
  `settle_category_id` int(11) NULL DEFAULT NULL COMMENT '结算类别id',
  `is_book` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病历本要否（要、否）',
  `regist_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收费方式（现金、银行卡、微信、医保卡、支付宝）',
  `visit_state` int(11) NULL DEFAULT NULL COMMENT '本次看诊状态（1-已完成\n2-医待接诊\n4-已退号）',
  `regist_money` decimal(8, 2) NULL DEFAULT NULL COMMENT '挂号金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES (99, 'M20250818691', '1', '男', '1', '1990-01-01', 35, '年', '北京市-北京市-东城区 1', '2025-08-19 09:00:00', '上午', '神经内科', '范无病', '3', 1, '是', '微信', 2, 8.00);
INSERT INTO `register` VALUES (100, 'M20250818692', '2', '男', '2', '2025-07-27', 23, '日', '2', '2025-08-18 15:54:50', '下午', '神经内科', '范无病', '1', 1, '否', '微信', 2, 50.00);
INSERT INTO `register` VALUES (101, 'M20250818649', '1', '男', '1', '1990-01-01', 35, '年', '北京市-北京市-东城区 1', '2025-08-24 09:00:00', '上午', '心血管内科', '扁鹊', '3', 1, '是', '微信', 2, 50.00);
INSERT INTO `register` VALUES (102, 'M20250818422', '1', '男', '1', '1990-01-01', 35, '年', '北京市-北京市-东城区 1', '2025-08-24 09:00:00', '上午', '心血管内科', '扁鹊', '3', 1, '是', '微信', 2, 50.00);
INSERT INTO `register` VALUES (103, 'M20250818904', '1', '男', '1', '1990-01-01', 35, '年', '北京市-北京市-东城区 1', '2025-08-24 09:00:00', '上午', '心血管内科', '扁鹊', '3', 1, '是', '微信', 2, 50.00);

-- ----------------------------
-- Table structure for scheduling
-- ----------------------------
DROP TABLE IF EXISTS `scheduling`;
CREATE TABLE `scheduling`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `rule_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排班说明',
  `week_rule` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班排规则14位01组成字符串，从星期日开始',
  `delmark` int(11) NULL DEFAULT 1 COMMENT '生效标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scheduling
-- ----------------------------
INSERT INTO `scheduling` VALUES (1, '星期一三五上午', '00100010001000', 1);
INSERT INTO `scheduling` VALUES (2, '星期一三五下午', '00010001000100', 1);
INSERT INTO `scheduling` VALUES (3, '星期二四六上午', '00001000100010', 1);
INSERT INTO `scheduling` VALUES (4, '星期二四六下午', '00000100010001', 1);
INSERT INTO `scheduling` VALUES (5, '周六周日全天', '11000000000011', 1);

-- ----------------------------
-- Table structure for settle_category
-- ----------------------------
DROP TABLE IF EXISTS `settle_category`;
CREATE TABLE `settle_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `settle_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别编码',
  `settle_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `sequence_no` int(11) NULL DEFAULT NULL COMMENT '显示顺序号',
  `delmark` int(11) NULL DEFAULT 1 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of settle_category
-- ----------------------------
INSERT INTO `settle_category` VALUES (1, 'js001', '自费', 1, 1);
INSERT INTO `settle_category` VALUES (2, 'js002', '市医保', 2, 1);

-- ----------------------------
-- Table structure for treatment_groups
-- ----------------------------
DROP TABLE IF EXISTS `treatment_groups`;
CREATE TABLE `treatment_groups`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `treatment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of treatment_groups
-- ----------------------------
INSERT INTO `treatment_groups` VALUES (1, '张三', '李四', '110101199001011234', '13800138000', '北京市朝阳区XX路XX号');
INSERT INTO `treatment_groups` VALUES (24, '李四', '1', '1', '1', '北京市-北京市-东城区 1');
INSERT INTO `treatment_groups` VALUES (27, '李四', '1', '1', '1', '北京市-北京市-东城区 1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_headPortrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_form` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (18, '李四', '', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (19, '111', '', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (20, '张三', '', '13174187420', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (21, '2', NULL, '2', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
