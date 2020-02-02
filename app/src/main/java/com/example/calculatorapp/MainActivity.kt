package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var numberList = mutableListOf<String>()
    var operatorList = mutableListOf<String>()
    var tempString: String = ""
    var lastPrsdNum:Boolean = false
    var firstNum: Float = 0.0f
    var secNum: Float = 0.0f
    var amtOfNum: Int = 0
    var addingNow: Boolean = false
    var answer:Float = 0.0f
    var opCount = 0
    var indxCuller = 0
    var sum = ""


    fun NumberInput(view: View) {


        var iD = view.id

        when(iD)
        {
            et1NumBtn.id -> {etCalculatorView.append("1")

                tempString += 1

            }
            et2NumBtn.id -> {etCalculatorView.append("2")

                tempString += 2

            }
            et3NumBtn.id -> {etCalculatorView.append("3")

                tempString += 3

            }
            et4NumBtn.id -> {etCalculatorView.append("4")

                tempString += 4

            }
            et5NumBtn.id -> {etCalculatorView.append("5")

                tempString += 5
            }
            et6NumBtn.id -> {etCalculatorView.append("6")

                tempString += 6
            }
            et7NumBtn.id -> {etCalculatorView.append("7")

                tempString += 7
            }
            et8NumBtn.id -> {etCalculatorView.append("8")

                tempString += 8
            }
            et9NumBtn.id -> {etCalculatorView.append("9")

                tempString += 9
            }
            et0NumBtn.id -> {etCalculatorView.append("0")

                tempString += 0
            }





        }



    }

    fun OperatorInput(view: View) {

        var iD = view.id

        when (iD) {
            etAddNumBtn.id -> {
                etCalculatorView.append("+")
                numberList.add(tempString)
                operatorList.add("+")
                tempString = ""
                indxCuller ++
            }
            etMinNumBtn.id -> {
                etCalculatorView.append("-")
                numberList.add(tempString)
                operatorList.add("-")
                tempString = ""
                indxCuller ++

            }
            etMulNumBtn.id -> {
                etCalculatorView.append("x")
                numberList.add(tempString)
                operatorList.add("x")
                tempString = ""
                indxCuller ++

            }
            etDivNumBtn.id -> {

                etCalculatorView.append("/")
                numberList.add(tempString)
                operatorList.add("/")
                tempString = ""


            }

            etPerNumBtn.id -> {

                etCalculatorView.append("%")
                numberList.add(tempString)
                operatorList.add("%")
                tempString = ""


            }
            etPiNumBtn.id -> {

                etCalculatorView.append("π")
                numberList.add(tempString)
                operatorList.add("π")
                tempString = ""
            }
            etPowNumBtn.id -> {

                etCalculatorView.append("^")
                numberList.add(tempString)
                operatorList.add("^")
                tempString = ""
            }

            etENumBtn.id -> {

                etCalculatorView.append("e")
                numberList.add(tempString)
                operatorList.add("e")
                tempString = ""
            }


        }
    }

    fun SolutionOutput(view: View) {

        numberList.add(tempString)

        while (operatorList.isNotEmpty()){

            when
            {
                operatorList.contains("π") ->
                {
                    when {
                        operatorList[opCount] == "π" -> {
                            Log.d("TAG",opCount.toString())
                            Log.d("TAG",numberList.toString())
                            Log.d("TAG",operatorList.toString())
                            sum =
                                (numberList[opCount].toFloat() * PI * numberList[opCount+1].toFloat()).toString()
                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }
                operatorList.contains("e") ->
                {
                    when {
                        operatorList[opCount] == "e" -> {
                            Log.d("TAG",opCount.toString())
                            Log.d("TAG",numberList.toString())
                            Log.d("TAG",operatorList.toString())
                            sum =
                                (numberList[opCount].toFloat() * E * numberList[opCount+1].toFloat()).toString()

                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }
                operatorList.contains("^") ->
                {
                    when {
                        operatorList[opCount] == "^" -> {
                            Log.d("TAG",opCount.toString())
                            Log.d("TAG",numberList.toString())
                            Log.d("TAG",operatorList.toString())
                            sum =
                                (numberList[opCount].toFloat().pow(numberList[opCount+1].toFloat())).toString()

                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }
                operatorList.contains("%") ->
                {
                    when {
                        operatorList[opCount] == "%" -> {
                            Log.d("TAG",opCount.toString())
                            Log.d("TAG",numberList.toString())
                            Log.d("TAG",operatorList.toString())
                            sum =
                                (numberList[opCount].toFloat() / 100 * numberList[opCount+1].toFloat()).toString()
                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }
                operatorList.contains("x") ->
                {
                    when {
                        operatorList[opCount] == "x" -> {
                            Log.d("TAG",opCount.toString())
                            Log.d("TAG",numberList.toString())
                            Log.d("TAG",operatorList.toString())
                            sum =
                                (numberList[opCount].toFloat() * numberList[opCount + 1].toFloat()).toString()
                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }

                operatorList.contains("/") ->
                {
                    when {
                        operatorList[opCount] == "/" -> {
                            sum =
                                (numberList[opCount].toFloat() / numberList[opCount+1].toFloat()).toString()
                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }

                operatorList.contains("+") ->
                {
                    when {
                        operatorList[opCount] == "+" -> {
                            sum =
                                (numberList[opCount].toFloat() + numberList[opCount + 1].toFloat()).toString()
                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }

                operatorList.contains("-") ->
                {
                    when {
                        operatorList[opCount] == "-" -> {
                            sum =
                                (numberList[opCount].toFloat() - numberList[opCount + 1].toFloat()).toString()
                            operatorList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.removeAt(opCount)
                            numberList.add(opCount, sum)
                            opCount = 0
                        }
                        else -> opCount++
                    }
                }



            }





        }
        answer = numberList[0].toFloat()
        etResultsScreen.text = answer.toString()
        opCount = 0



    }

    fun ClearInput(view: View) {

        etCalculatorView.text = ""
        etResultsScreen.text = ""
        tempString = ""
        indxCuller = 0
        numberList.clear()
        operatorList.clear()


    }


}
