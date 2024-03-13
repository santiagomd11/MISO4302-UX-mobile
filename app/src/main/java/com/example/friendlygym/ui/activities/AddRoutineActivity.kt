package com.example.friendlygym.ui.activities
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.friendlygym.R

class AddRoutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_routine)

        val editTextRoutineName: EditText = findViewById(R.id.edit_text_routine_name)
        val buttonSave: Button = findViewById(R.id.button_save)
        val buttonCancel: Button = findViewById(R.id.button_cancel)

        buttonSave.setOnClickListener {
            val routineName = editTextRoutineName.text.toString()
            if (routineName.isNotEmpty()) {
                val intent = Intent()
                intent.putExtra(EXTRA_ROUTINE_NAME, routineName)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

        buttonCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    companion object {
        const val EXTRA_ROUTINE_NAME = "EXTRA_ROUTINE_NAME"
    }
}
