import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//在 Groovy 中 "一切都是对象"
a = 'hello world'
b = 123
c = 1.23
d = [1,2,3]

println a.class
println b.class
println c.class
println d.class

String e='555'
ee = e as int
println ee.class
//循环
//------------------------------------------------------
def repeat(val,repeat=5){
	for (i in 0..repeat){ //i=0;i<5;i++
		println val
	}
}

repeat(a,3)
//集合--- Java 编程中是如何使用集合的 — 导入 java.util 类，初始化集合，将项加入集合。这三个步骤都会增加不少代码
//每个 Groovy 集合都是 java.util.Collection 或 java.util.Map 的实例。
//------------------------------------------------------
def range = 0..4
println range.class
assert range instanceof List
//######################################################
def Ename=['allen','bill','cystal']
assert Ename instanceof Collection
assert Ename instanceof ArrayList
//------------------------------------------------------
Ename.add('dell')
Ename<< "emma"
Ename[5]='frank'
println Ename
//######################################################
def Nums = [1,2,3,4]
assert Nums+5,6==[1,2,3,4,5,6]
assert Nums-1 == [2,3,4]

assert Nums.size == 4
assert Nums.count(1)==1

assert Ename*.toUpperCase() ==['ALLEN', 'BILL', 'CYSTAL', 'DELL', 'EMMA', 'FRANK']
//------------------------------------------------------
def hash = [name:'allen', age:38, level:'senior']
hash.put('id',1087)
println hash
assert hash.get('name')=='allen'
hash.dod='2020/08/06'
println hash
assert hash.dod == '2020/08/06'
hash["gender"] = "male"
assert hash.gender == "male"
assert hash["gender"] == "male"
//闭包:闭包中的 it 变量是一个关键字，指向被调用的外部集合的每个值 — 它是默认值，可以用传递给闭包的参数覆盖它,闭包是一个开放的、匿名的、可以接受参数和返回值的代码块。
//------------------------------------------------------
//######################################################
Ename.each{
	println it
}
//######################################################
Ename.each{ value ->
	println value
}
//######################################################
hash.each{ key,value ->
	println "${key} : ${value}"
}
//######带参数的闭包---------------------------------------
def excite = { word ->
	return "${word}!!"
   }

assert excite('allen') == 'allen!!'
assert excite.call('bill') == 'bill!!'
