/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const domain={
 code:'DLP',systemName:'数据防泄漏管理平台',englishName:'DATA LOSS PREVENTION',theme:{primary:'#586079',dark:'#303543',accent:'#b87947'},
 workspace:'数据安全部 / 防护运营中心',fieldWorkspace:'敏感数据运营组',period:'2026-08-01 · 日常监测',liveText:'数据通道策略于 10:36 同步',fieldContextLabel:'当前防护域',fieldContext:'办公终端 · 生产策略',fieldUser:'林岚',fieldRole:'数据安全专员',adminUser:'周序',adminRole:'数据安全负责人',
 adminTitle:'企业数据防护控制台',adminBreadcrumb:'数据安全 / 风险总览',adminSubtitle:'统一监测敏感数据、外发通道、策略命中、事件调查与处置闭环。',exportAction:'导出数据安全月报',createAction:'新建防护策略',
 chartTitle:'敏感数据风险趋势',chartSubtitle:'累计处置率 / 管理目标',chartLabels:['00:00','03:00','06:00','09:00','12:00','15:00','18:00','21:00','24:00'],loadTitle:'数据通道风险负荷',loadSubtitle:'开放事件占当日处置能力',recordsTitle:'重点数据风险事件',recordsSubtitle:'按数据等级、外发通道与影响范围排序',issueTitle:'高风险策略命中',issueSubtitle:'需要数据责任人与安全团队确认的行为',
 recordName:'数据事件',itemName:'数据资产 / 策略',unitName:'责任部门',batchName:'敏感等级',planName:'检测文件',doneName:'已核验',exceptionName:'风险对象',unitLabel:'个',
 listBreadcrumb:'数据防护 / 事件台账',listSubtitle:'管理策略命中、行为核验、业务豁免、响应处置与证据留存。',listSummary:[['今日策略命中','368'],['有效风险事件','29'],['待业务确认','8'],['高风险事件','4',true]],tabs:['全部','待确认','调查中','处置中','已关闭'],
 fieldBreadcrumb:'数据防护 / 专员工作台',fieldTitle:'敏感数据运营工作台',fieldSubtitle:'当前 6 个调查任务 · 4 个高风险事件 · 数据安全专员林岚',fieldSecondary:'查看数据分级',reportAction:'提交核验',fieldNoticeTitle:'敏感内容已按权限脱敏展示',fieldNotice:'下载、复制与截图行为均写入审计记录',
 steps:['策略命中','行为核验','业务确认','响应处置','证据归档'],documentAction:'查看策略依据',printAction:'导出取证摘要',resourceCardTitle:'防护通道状态',resourceValueLabel:'生效策略',resourceHealthLabel:'终端覆盖率',quickSubtitle:'数据防护运营常用入口',quickActions:[['事件核验','/shopfloor/report','对象、用途与处置结论'],['策略申请','/shopfloor/material','豁免、例外与业务场景'],['数据目录','/shopfloor/resources','分类、分级与责任人'],['风险升级','/shopfloor/andon','大规模外发与监管影响']],
 reportDefaults:[10,1],reportTitle:'数据风险核验',reportSubtitle:'记录核验对象、未关闭风险和业务判断。',reportSuccess:'核验结论已保存并通知数据责任人',reportPlaceholder:'填写数据用途、接收方、授权依据和处置建议',reportFootnote:'提交后更新风险评分并固化证据链',ruleTitle:'敏感数据防护策略',ruleSubtitle:'DLP-OFFICE-L3 · V7.2',rules:[['敏感等级','三级'],['外发阈值','≥ 10 条'],['证据留存','180 天'],['策略状态','生产生效',true]],fieldTotals:[['368','今日策略命中'],['29','有效风险事件'],['8','待业务确认'],['97.8%','终端覆盖率']],
 adminMenus:[['/admin','home','数据防护控制台'],['/admin/work-orders','order','风险事件'],['/admin/samples','box','敏感数据'],['/admin/schedule','calendar','策略计划'],['/admin/methods','process','防护策略'],['/admin/reviews','quality','豁免审批'],['/admin/resources','machine','数据资产'],['/admin/report','chart','风险分析']],
 fieldMenus:[['/shopfloor','home','专员工作台'],['/shopfloor/report','report','事件核验'],['/shopfloor/tasks','order','调查任务'],['/shopfloor/material','box','策略申请'],['/shopfloor/resources','machine','数据目录'],['/shopfloor/andon','risk','风险升级',4]],
 moduleTitles:{tasks:['调查任务','查看数据等级、通道、责任人与响应期限'],material:['策略申请','处理业务豁免、例外授权和临时放行'],resources:['数据目录','查看数据分类、等级、位置和责任人'],andon:['风险升级','发起重大数据事件和跨部门响应'],samples:['敏感数据','维护识别规则、样本和数据指纹'],schedule:['策略计划','协调灰度发布、观察与正式生效窗口'],methods:['防护策略','配置终端、邮件、网络与云通道规则'],reviews:['豁免审批','评估业务必要性、期限和补偿控制'],report:['风险分析','分析数据流向、事件结构和高风险行为']},
 tagline:'让敏感数据在可控边界内安全流动',storyTitle:'从数据识别到外发响应，<br/>每一次敏感操作都有清晰依据。',storyText:'连接数据资产、内容识别、通道策略、业务授权和事件响应的数据安全底座。',pattern:[2,5,6,9,12,15,17,20,23,26,28,31],loginStats:[['97.8%','终端覆盖率'],['368','今日策略命中'],['29','有效风险事件']],loginTitle:'企业数据防护运营中心',adminDemo:'数据 / 策略 / 风险',fieldDemo:'核验 / 豁免 / 处置'
}
export const records=[
 {no:'DLP-260801-018',name:'研发源代码外发行为核验',code:'DATA-SOURCE-CODE',unit:'研发中心',group:'敏感数据运营组',plan:126,done:84,exception:12,due:'08-01',batch:'机密 L3',status:'调查中',progress:64,priority:'加急'},
 {no:'DLP-260801-021',name:'客户清单邮件外发确认',code:'DATA-CUSTOMER',unit:'销售运营部',group:'客户数据域',plan:38,done:31,exception:2,due:'08-01',batch:'敏感 L2',status:'业务确认',progress:79,priority:'关注'},
 {no:'DLP-260802-006',name:'供应商银行信息云盘共享',code:'DATA-SUP-BANK',unit:'采购中心',group:'供应商数据域',plan:24,done:0,exception:0,due:'08-02',batch:'机密 L3',status:'待确认',progress:16,priority:'正常'},
 {no:'DLP-260731-015',name:'员工信息打印行为复核',code:'DATA-EMPLOYEE',unit:'人力资源部',group:'员工数据域',plan:46,done:46,exception:0,due:'08-01',batch:'敏感 L2',status:'已关闭',progress:100,priority:'正常'},
 {no:'DLP-260801-024',name:'财务报表移动存储复制',code:'DATA-FIN-REPORT',unit:'集团财务',group:'财务数据域',plan:18,done:7,exception:5,due:'08-01',batch:'核心 L4',status:'升级处置',progress:48,priority:'加急'}]
export const resources=[{code:'CHANNEL-ENDPOINT-01',name:'终端数据防护',unit:'数据安全部',status:'在线',health:98,value:'186',valueUnit:'条',note:'覆盖 8,420 个办公终端'},{code:'CHANNEL-MAIL-02',name:'邮件外发防护',unit:'数据安全部',status:'在线',health:95,value:'74',valueUnit:'条',note:'企业邮箱策略同步正常'},{code:'CHANNEL-CLOUD-03',name:'云盘共享防护',unit:'数据安全部',status:'预警',health:73,value:'42',valueUnit:'条',note:'两个租户授权范围待收敛'}]
export const reviews=[{no:'DLP-260801-032',title:'研发代码外发豁免评估',type:'业务豁免',detail:'12 个文件 · 周序',result:'待确认'},{no:'DLP-260801-011',title:'客户清单邮件授权复核',type:'业务确认',detail:'接收方 2 家 · 林岚',result:'通过'},{no:'DLP-260728-018',title:'云盘共享范围检查',type:'策略健康',detail:'异常租户 2 个',result:'异常'}]
export const adminMetrics=[['今日策略命中','368','较昨日减少 6%','blue'],['有效风险事件','29','命中转化率 7.9%','green'],['待业务确认','8','3 项临近时限','orange'],['高风险事件','4','涉及核心与机密数据','red']]
export const fieldMetrics=[['我的调查','6','4 个高风险事件','blue'],['今日已关闭','14','平均 52 分钟','green'],['待业务确认','8','3 项即将超时','orange'],['终端覆盖','97.8%','防护状态正常','slate']]
export const chartActual=[21,32,45,54,62,72,79,86,91],chartTarget=[23,35,48,58,68,77,84,91,96]
export const loads=[['终端复制通道',88,'开放事件 11 个'],['企业邮件通道',81,'开放事件 8 个'],['云盘共享通道',76,'开放事件 6 个'],['打印输出通道',62,'开放事件 4 个']]
export const issues=[{type:'代码',title:'研发源代码疑似发送至个人邮箱',detail:'12 个文件 · 已阻断发送',status:'调查中'},{type:'财务',title:'核心财务报表复制至移动介质',detail:'涉及 5 个文件',status:'响应中'},{type:'云盘',title:'外部共享链接权限范围过大',detail:'涉及 2 个云盘租户',status:'收敛中'}]
