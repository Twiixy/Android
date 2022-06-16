package com.example.projekt

import android.app.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.projekt.MainActivity
import com.example.projekt.addAusgabe
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

import org.w3c.dom.Text
import java.text.FieldPosition
import java.util.*


class addAusgabe : AppCompatActivity(),DatePickerDialog.OnDateSetListener {

    var day=0
    var month = 0
    var year =0
    var savedday=0
    var savedmonth = 0
    var savedyear =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_ausgabe)
        val actionbar = supportActionBar
        actionbar!!.title="Neue Ausgabe"
        actionbar.setDisplayHomeAsUpEnabled(true)

        pickDate()




        val standortbutton = findViewById<Button>(R.id.buttonStandort)
        standortbutton.setOnClickListener()
        {
            val intent = Intent(this,MapsActivity::class.java);
            startActivity(intent)
        }



        val Spinner = findViewById<Spinner>(R.id.SpinnerFiliale)

        val empty =  resources.getStringArray(R.array.filialen_namen)
        val arrayadapter =ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,empty)
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        Spinner.adapter = arrayadapter
        Spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext,"Ausgewählte Filiale: "+empty[p2],Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



        val Spinner2 = findViewById<Spinner>(R.id.SpinnerEmpfänger)// Empfänger auswahl

        val empty2 =  resources.getStringArray(R.array.empfänger_auswahl)
        val arrayadapter2 =ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,empty2)
        arrayadapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        Spinner2.adapter = arrayadapter2
        Spinner2.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext,"Ausgewählter Empfänger: "+empty2[p2],Toast.LENGTH_SHORT).show()

                val empfängerAuswahlName =  findViewById<EditText>(R.id.EmpfängerAuswahlName)


                if(p2==0)//=Name
                {
                    empfängerAuswahlName.setVisibility(View.VISIBLE)


                }
                else
                {
                    empfängerAuswahlName.setVisibility(View.INVISIBLE)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //verwendungszweck_auswahl

        val Spinner3 = findViewById<Spinner>(R.id.SpinnerVerwendungszweck)// Empfänger auswahl

        val empty3 =  resources.getStringArray(R.array.verwendungszweck_auswahl)
        val arrayadapter3 =ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,empty3)
        arrayadapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        Spinner3.adapter = arrayadapter3
        Spinner3.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext,"Ausgewählter Empfänger: "+empty3[p2],Toast.LENGTH_SHORT).show()

                val textviewselected = findViewById<TextView>(R.id.chooseFiliale)
                val textviewdynamisch = findViewById<EditText>(R.id.textViewverwendungszweckdynamisch)

                if(p2==0)//Lebensmittel
                {

                    Spinner.setVisibility(View.VISIBLE)
                    textviewselected.setVisibility(View.VISIBLE)
                    textviewdynamisch.setVisibility(View.INVISIBLE)

                }
                else if(p2==1)//Restaurant
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Name des Restaurants")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else if(p2==2)//Miete
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Betrag in Euro")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else if(p2==3)//AutoundService
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Betrag in Euro")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else if(p2==4)//Urlaub
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Urlaubsziel")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else if(p2==5)//Entertainment
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Beschreibung")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else if(p2==6)//Kleidung
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Ort/Filiale")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else if(p2==7 || p2==8)//Schreibwaren
                {
                    textviewdynamisch.setVisibility(View.VISIBLE)
                    textviewdynamisch.setHint("Artikel")
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)

                }
                else
                {
                    Spinner.setVisibility(View.INVISIBLE)
                    textviewselected.setVisibility(View.INVISIBLE)
                    textviewdynamisch.setVisibility(View.INVISIBLE)
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



        val Spinner4 = findViewById<Spinner>(R.id.SpinnerEinundAusgabe)// Empfänger auswahl

        val empty4 =  resources.getStringArray(R.array.EinundAusgabe_auswahl)
        val arrayadapter4 =ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,empty4)
        arrayadapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        Spinner4.adapter = arrayadapter4
        Spinner4.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext,"Ausgewählter Empfänger: "+empty4[p2],Toast.LENGTH_SHORT).show()



            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val pericheckbox = findViewById<CheckBox>(R.id.checkBoxPeriodisch)

        pericheckbox.setOnClickListener()
        {
            if (pericheckbox.isChecked) {
                val edittext = findViewById<EditText>(R.id.editTextPeriodischTage)

                edittext.setVisibility(View.VISIBLE)
                pericheckbox.setText("Ja")
            } else {
                val edittext = findViewById<EditText>(R.id.editTextPeriodischTage)

                edittext.setVisibility(View.INVISIBLE)
                pericheckbox.setText("Nein")
            }
        }




    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

        savedday=p3
        savedmonth=p2+1
        savedyear=p1
        getDateTimeCalendar()

        val textdatum = findViewById<TextView>(R.id.textViewDatum)
        textdatum.text="Datum: $savedday.$savedmonth.$savedyear"
    }

    private fun getDateTimeCalendar()
    {
        val cal:Calendar= Calendar.getInstance()
        day=cal.get(Calendar.DAY_OF_MONTH)
        month=cal.get(Calendar.MONTH)
        year=cal.get(Calendar.YEAR)
    }

    private fun pickDate()
    {
        val button = findViewById<Button>(R.id.buttonDatum)
        button.setOnClickListener(){

            getDateTimeCalendar()
            DatePickerDialog(this,this,year,month,day).show()
        }
    }

}