package com.example.goal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitItem(){
    val textboxGradient = Brush.horizontalGradient(
        listOf(
            Color(0xFF37C871),
            Color(0xff5FE394)
        )
    )
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .background(
                Color(0xFFEDFFF4)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Text(
            "Meditating",
            modifier = Modifier
                .wrapContentHeight()

                .weight(0.8f)
            ,
            color = Color(0xFF37C871),
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
        )

        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                },
                enabled = checked,
                modifier = Modifier.background(brush = textboxGradient),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White,
                    disabledUncheckedColor = Color.White
                )
            )
        }
        Icon(
            Icons.Filled.MoreVert,
            contentDescription = null,
        )

    }
}


@Composable
fun SettingsItem(){
    Row(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().clip(RoundedCornerShape(9.dp)).background(Color(0xFFfbfbfb)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("Account",
            modifier = Modifier.padding(12.dp)
                .weight(0.8f),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
            )
        Icon(
            Icons.Filled.KeyboardArrowRight,
            contentDescription = null
        )

    }
}

@Composable
fun SettingsPage(){
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .background(color = colorResource(R.color.silver))
            .padding(10.dp)
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ){
        Text("Settings", fontSize = 29.sp, fontWeight = FontWeight.Bold)
        Column(
            modifier = Modifier.clip(RoundedCornerShape(6.dp)).background(Color.White).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)){
            for(i in 1..5){
                SettingsItem()
            }
        }
    }
}


@Composable
fun JournalingPage(){
    val textboxGradient = Brush.horizontalGradient(
        listOf(
            Color(0xFF37C871),
            Color(0xff5FE394)
        )
    )
    Column(
        modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.silver)).padding(15.dp)
    ){
        Text("July 4 2022")
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(top =15.dp)
        ){
            Icon(Icons.Filled.ArrowBack, contentDescription = null)
            Text("Goals: Journaling Everyday", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        }
        Column(
            modifier = Modifier.padding(top =20.dp).clip(RoundedCornerShape(20.dp)).background(Color.White)
        ) {
            CalendarView()
        }
        Column(
            modifier = Modifier.padding(top =20.dp).clip(RoundedCornerShape(20.dp)).background(Color.White)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(11.dp)) .background(Color(0xfffbfbfb)).padding(12.dp)
            ){
                Row (verticalAlignment =Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ){

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier =Modifier.weight(0.7f)
                    ) {
                        Text("Journaling Everyday", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Text("Achieved",
                        fontWeight = FontWeight.SemiBold,
                        modifier =Modifier.clip(RoundedCornerShape(35.dp)).background(Color(0xffd7ffe7)).padding(10.dp),
                        style = TextStyle(textboxGradient))

                }
                for(i in 1..6) {
                    Row(modifier = Modifier.padding(top = 30.dp)) {
                        Text(
                            "Habit Name",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(0.8f)
                        )
                        Text("Journaling", fontWeight = FontWeight.Normal, fontSize = 16.sp)
                    }
                }
            }
        }
    }

}

@Composable
fun CalendarView() {
    val currentMonth = remember { mutableStateOf(Calendar.getInstance()) }
    val calendar = currentMonth.value
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xffFFA450),
            colorResource(R.color.orange)

        ))
    Column(
        modifier = Modifier.background(Color.White).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.KeyboardArrowLeft, null,
                modifier = Modifier.clickable {
                    changeMonth(calendar, -1)
                },
            )

            Text(
                text = SimpleDateFormat("MMMM\n  yyyy").format(calendar.time),
                style = TextStyle(gradient)
                // modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                Icons.Filled.KeyboardArrowRight, null,
                modifier = Modifier.clickable {
                    changeMonth(calendar, 1)
                },
            )
        }

        // Days of the week header
        Row {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                Text(
                    it,
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }

        // Days grid
        val daysInMonth = getDaysInMonth(calendar)
        LazyVerticalGrid(

            columns = GridCells.Fixed(7),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            daysInMonth.forEach { day ->
                item {
                    Text(
                        text = if (day != 0) day.toString() else "",
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        }
    }
    }

fun changeMonth(calendar: Calendar, delta: Int) {
    calendar.add(Calendar.MONTH, delta)
}

fun getDaysInMonth(calendar: Calendar): List<Int> {
    val daysInMonth = mutableListOf<Int>()
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
    val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    // Add empty spaces for the days before the 1st day of the month
    repeat(firstDayOfWeek) {
        daysInMonth.add(0) // 0 means empty space
    }

    // Add days of the month
    for (day in 1..maxDays) {
        daysInMonth.add(day)
    }

    return daysInMonth
}
@Composable
fun ProgressReportPage(){
    var dropdownPeriod by remember { mutableStateOf(false) }
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xffFFA450),
            colorResource(R.color.orange)

        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.silver))
            .padding(20.dp)
    )
    {
        Text("Progress", fontSize = 29.sp, fontWeight = FontWeight.Bold)
            Row (
                modifier =Modifier.fillMaxWidth().padding(top =20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Text("Progress Report", fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.8f))
                Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .width(150.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFe7e7e7))
                    .padding(vertical = 5.dp)
                    .padding(horizontal = 15.dp)
                    .clickable {
                        dropdownPeriod = true
                    }
            ) {

                    Row {
                        Text("This Month", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Icon(
                            Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                        )
                    }
                    DropdownMenu(
                        expanded = dropdownPeriod,
                        onDismissRequest = {
                            dropdownPeriod = false
                        }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text("30 days")
                            },
                            onClick = {
                                dropdownPeriod = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text("7 days")
                            },
                            onClick = {
                                dropdownPeriod = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text("100 days")
                            },
                            onClick = {
                                dropdownPeriod = false
                            }
                        )
                    }
                }

        }
        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()
            .padding(top = 10.dp)
            .clip(RoundedCornerShape(10.dp))

        .background(Color.White).padding(12.dp)
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Your Goals", fontSize = 21.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(0.9f))
                Text(
                    "see all",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = gradient
                    )
                )
            }
            Box(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = 0.7f,
                    color = colorResource(R.color.orange),
                    strokeWidth = 10.dp,
                    strokeCap = StrokeCap.Round,
                    trackColor = colorResource(R.color.silver),
                    modifier = Modifier
                        .size(80.dp)
                )
            }
            Text("11 Habits of Goals Acheived",
                modifier = Modifier.fillMaxWidth().padding(top =20.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                style = TextStyle(
                    gradient
                )
            )
            Text("6 Habits goal has'nt acheived",
                modifier = Modifier.fillMaxWidth().padding(top =10.dp, bottom = 40.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color(0xFFa2a2a2)
            )
            Column(verticalArrangement = Arrangement.spacedBy(15.dp)){
                for(i in 1..3) {
                    ProgressItem()
                }
            }
            Text(
                "see all",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    brush = gradient
                ),
                modifier = Modifier.fillMaxWidth().padding(top =30.dp),
                textAlign = TextAlign.Center
            )
        }


    }
}

@Composable
fun ProgressItem(){
    val textboxGradient = Brush.horizontalGradient(
        listOf(
            Color(0xFF37C871),
            Color(0xff5FE394)
        )
    )
    Column(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(11.dp)) .background(Color(0xfffbfbfb)).padding(12.dp)
    ){
        Row (verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
            ){
            CircularProgressIndicator(
                progress = 0.7f,
                color = Color(0xFF37c671),
                strokeWidth = 4.dp,
                strokeCap = StrokeCap.Round,
                trackColor = colorResource(R.color.silver),
                modifier = Modifier
                    .size(50.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier =Modifier.weight(0.7f)
            ) {
                Text("Journaling Everyday", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text("7 from 7 days target", fontSize = 14.sp, color = colorResource(R.color.font_black))
            }

            Text("Achieved",
                fontWeight = FontWeight.SemiBold,
                modifier =Modifier.clip(RoundedCornerShape(35.dp)).background(Color(0xffd7ffe7)).padding(10.dp),
                style = TextStyle(textboxGradient))
        }
    }
}

@Composable
fun DeleteSuccess(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp)
                .padding(bottom = 30.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.weight(0.9f))
                Icon(
                    Icons.Filled.Close,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clickable {
                            // onClickClose()
                        }
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFe0e0e0))
            )
            Box (Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .size(60.dp),
                    tint = Color.DarkGray
                )
                Box(contentAlignment = Alignment.Center,

                    modifier = Modifier
                        .padding(start = 60.dp)
                        .size(25.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.Black)
                    ){
                Icon(
                    Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Green
                )
                }

            }
            Text("List has been Deleted",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            ButtonGradient("Ok")

        }
    }

@Composable
fun DeletePage(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
            .padding(horizontal = 20.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.weight(0.9f))
            Icon(
                Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clickable {
                        // onClickClose()
                    }
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xFFe0e0e0))
        )
        Box (Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Icon(
                Icons.Filled.Delete,
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .size(60.dp),
                tint = Color.DarkGray
            )

        }
        Text("Are you sure you want to delete?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        ButtonGradient("Delete")
        Text("Cancel",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 50.dp),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun GoalItem(){
    var clickMore by remember{
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xfffbfbfb))
            .padding(vertical = 11.dp)
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Row {
            Text(
                "Finish 5 Philosophy books",
                color = colorResource(R.color.font_black),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(0.9f)
            )
            Row{
            Icon(
                Icons.Filled.MoreVert,
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
                    .clickable {
                        clickMore = true
                    }
            )
            if(clickMore){
                DropdownMenu(
                    expanded = clickMore,
                    onDismissRequest = {
                        clickMore = !clickMore
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text("Edit")
                        },
                        onClick = {

                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text("Delete")
                        },
                        onClick = {

                        }
                    )
                }
                }
            }

        }
        LinearProgressIndicator(
            progress = 0.7f,
            modifier = Modifier
                .padding(end = 20.dp)
                .fillMaxWidth()
                .height(14.dp),
            color  = colorResource(R.color.orange),
            strokeCap = StrokeCap.Round,
            trackColor = colorResource(R.color.sandal)
        )

        Text(
            "5 from 7 days target",
                color = colorResource(R.color.font_black),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.nunito_bolod)),
            fontWeight = FontWeight.Medium
        )
        Text(
            "Everyday",
                color = Color(0xFFff5c00),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }

}

@Composable
fun CreateHabit(onClickClose : () ->Unit){
    var dropdownPeriod by remember { mutableStateOf(false) }
    var dropdownHabit by remember { mutableStateOf(false) }
    var selectedPeriod by remember { mutableStateOf("30 days") }
    var selectedHabit by remember { mutableStateOf("Everyday") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(4.dp))
            .background(colorResource(R.color.silver))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Create New Habit Goal",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(0.8f)
            )
            Icon(
                Icons.Filled.Close,
                contentDescription = null,
                modifier =  Modifier.clickable { 
                    onClickClose()
                }
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(bottom = 20.dp)
        )
        TextBox("Your Name")
        TextBox("Habit Goal")
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Period", fontWeight = FontWeight.SemiBold, fontSize = 14.sp ,
                fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                modifier = Modifier.weight(0.8f)
            )
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .width(150.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFe7e7e7))
                    .padding(vertical = 5.dp)
                    .padding(horizontal = 15.dp)
                    .clickable {
                        dropdownPeriod = true
                    }
            ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Text(selectedPeriod, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                    )
                }
                DropdownMenu(
                    expanded = dropdownPeriod,
                    onDismissRequest = {
                        dropdownPeriod = false
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text("30 days")
                        },
                        onClick = {
                            selectedPeriod = "30"
                            dropdownPeriod = false
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text("7 days")
                        },
                        onClick = {
                            selectedPeriod = "30"
                            dropdownPeriod = false
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text("100 days")
                        },
                        onClick = {
                            selectedPeriod = "30"
                            dropdownPeriod = false
                        }
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Habit Type", fontWeight = FontWeight.SemiBold, fontSize = 14.sp ,
                fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                modifier = Modifier.weight(0.8f)
            )
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .width(150.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFe7e7e7))
                    .padding(vertical = 5.dp)
                    .padding(horizontal = 15.dp)
                    .clickable {
                        dropdownHabit = true
                    }
            ) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Text(selectedHabit, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                    )
                }
                DropdownMenu(
                    expanded = dropdownHabit,
                    onDismissRequest = {
                        dropdownHabit = false
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(".")
                        },
                        onClick = {
                            selectedHabit = "Everyday"
                            dropdownHabit = false
                        }
                    )
                }
            }
        }
        ButtonGradient("Create New")

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(){
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {3})
    val coroutineScope = rememberCoroutineScope()
    var showCreateHabitDialog by remember { mutableStateOf(false) }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showCreateHabitDialog = true
                }
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = null
                )
            }
        },
        bottomBar = {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 10.dp)
            ) {
                val tabs = listOf(Icons.Filled.Home, Icons.Filled.Star, Icons.Filled.Settings)
                tabs.forEachIndexed { index, icon ->
                    Tab(
                        modifier = Modifier.size(50.dp),
                        selected = index ==pagerState.currentPage,
                        onClick = {
                                coroutineScope.launch {
                                    pagerState.scrollToPage(index)
                                }
                        }
                    ) {
                        Icon(
                            icon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

            }
        }
    ){padding->
          Column(modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.silver))){
            HorizontalPager(
            state = pagerState,
                modifier = Modifier.padding( padding)
            ) {currentPage->
                when(currentPage){
                    0->{
                        HomePage()
                        if(showCreateHabitDialog){
                            AlertDialog(
                                onDismissRequest = {
                                    showCreateHabitDialog = false
                                }
                            ){
                                CreateHabit(){
                                    showCreateHabitDialog = false

                                }
                            }
                        }
                    }
                    1->{
                        ProgressReportPage()
                    }
                    2->{
                        SettingsPage()
                    }
                }

            }
          }
    }

}


@Composable
fun HomePage(){
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xffFFA450),
            colorResource(R.color.orange)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.silver))
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ){
        Text(
            "Sun 1, March 2022",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.nunito_bolod)),
            color = colorResource(R.color.font_black),
            fontWeight = FontWeight.Bold
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)){
            Text(
                "Hello,",
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                color = colorResource(R.color.font_black),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                "Sussy,",
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                color = colorResource(R.color.orange),
                fontWeight = FontWeight.SemiBold
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Transparent),
        ) {
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(gradient),
                contentAlignment = Alignment.Center
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Box(contentAlignment = Alignment.CenterStart) {
                        CircularProgressIndicator(
                            progress = 0.7f,
                            color = Color.White,
                            strokeWidth = 7.dp,
                            strokeCap = StrokeCap.Round,
                            trackColor = colorResource(R.color.sandal ),
                            modifier = Modifier
                                .size(80.dp)
                        )
                        Text(
                            text = "70%",
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.white),
                            modifier = Modifier.padding(start = 25.dp)
                        )
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            "3 of 5 habits",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text("Completed Today", fontSize = 20.sp, color = Color.White)
                    }
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 15.dp, end = 10.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(R.drawable.banner_logo),
                    contentDescription = null,
                )
            }
        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(14.dp)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                Text(
                    "Today Habit",
                    fontSize = 21.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.8f)
                )
                Text(
                    "see all",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = gradient
                    )
                )


            }

            Column(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                for (i in 1..3)
                        HabitItem()

            }
        }

            Column(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White)
                    .padding(14.dp)
            )
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Text(
                        "Your Goals",
                        fontSize = 21.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(0.8f)
                    )
                    Text(
                        "see all",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            brush = gradient
                        )
                    )


                }

                Column(
                    modifier = Modifier.padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    for (i in 1..3)
                            GoalItem()

                }

            }
        }


}

@Composable
fun DateItem(){
     Column(
         modifier = Modifier
             .clip(RoundedCornerShape(4.dp))
             .size(65.dp)
             .background(Color(0xFFffeddc))
             .border(width = 1.dp, color = Color(0xffd9b6), shape = RoundedCornerShape(4.dp))
             .padding(10.dp),

     ){
         val gradient = Brush.horizontalGradient(
             listOf(
                 Color(0xffFFA450),
                 colorResource(R.color.orange)

             )
         )
         Text("1",
             modifier =Modifier.fillMaxWidth(),
             textAlign = TextAlign.Center,
             fontSize = 21.sp,
             style = TextStyle(
                 brush = gradient
             ),
             fontWeight = FontWeight.W600
             )
         Text("March",    modifier =Modifier.fillMaxWidth(),
             textAlign = TextAlign.Center,
             fontSize = 14.sp,
             style = TextStyle(
                 brush = gradient
             ),
             fontWeight = FontWeight.W500
         )
     }
}


@Composable
fun YourGoalsPage(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.silver))
            .padding(20.dp)){



        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(14.dp)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            )
            {
                Icon(
                    Icons.Filled.ArrowBack, contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    "Your Goals",
                    fontSize = 21.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                    fontWeight = FontWeight.W500,
                    color = colorResource(R.color.font_black)
                )

            }

            Column(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                for (i in 1..3)
                    GoalItem()

            }

        }

    }

@Composable
fun YourHabitsPage(){
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xffFFA450),
            colorResource(R.color.orange)

        )
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.silver))
        .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Filled.ArrowBack, contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                "Your Habits",
                fontWeight = FontWeight.W500,
                fontSize = 21.sp,
                color = colorResource(R.color.font_black)
            )
        }
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        )
        {
            items(10) {
                DateItem()
            }
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(14.dp)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                Text(
                    "Today Habit",
                    fontSize = 21.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.8f)
                )
                Text(
                    "see all",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bolod)),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = gradient
                    )
                )


            }

            Column(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                for (i in 1..3)
                    HabitItem()

            }
        }
    }
    }
}