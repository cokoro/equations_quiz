# Equations_quiz 
<img src="https://cl.ly/253C1R0I391q/Image%202017-11-06%20at%205.08.28%20%E4%B8%8B%E5%8D%88.png" />

A layout to transition between two views using a Floating Action Button as shown in many Material Design concepts

### API Level & AVD setting  

API 23 & Nexus S

### Usage
#### Part 1
<img src="https://cl.ly/2v260F2M2337/Screen%20Recording%202017-11-06%20at%2005.09%20%E4%B8%8B%E5%8D%88.gif">
</img>

An Android application to practice students’ ability in solving algebraic equations. The application focus on linear and quadratic equations,in the form of a quiz in which 10 random questions are generated in sequence. The first 5 questions are about linear equation while the next 5 questions are about quadratic equation. 

The first page contain name and university number for identification purpose. The second page is the quiz main frame
which will be loaded when the “Start Quiz” button on the first page is pressed.

``` xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/background">

    <ImageView
        android:id="@+id/game_cover_image"
        android:src="@drawable/mgs"
        style="@style/GameCoverStyle" />

    <com.truizlop.fabreveallayout.FABRevealLayout
        android:id="@+id/fab_reveal_layout"
        android:layout_width="match_parent"
        android:layout_height="@dimen/fab_reveal_height"
        >

        <android.support.design.widget.FloatingActionButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:backgroundTint="@color/fab"
            android:src="@drawable/ic_add_shopping_cart"
            />

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            >

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:layout_centerInParent="true">

                <TextView
                    android:id="@+id/game_title_text"
                    android:text="@string/game_title"
                    style="@style/GameTitleStyle" />

                <TextView
                    android:id="@+id/creator_name_text"
                    android:text="@string/creator_name"
                    style="@style/GameCreatorStyle" />
            </LinearLayout>

        </RelativeLayout>

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            >

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/add_to_shopping_cart"
                android:textColor="@color/white"
                android:textSize="16sp"
                android:layout_centerInParent="true"
                />
        </RelativeLayout>

    </com.truizlop.fabreveallayout.FABRevealLayout>
</LinearLayout>
```


#### Part 2
On the second page, A layout contains:
  1 TextView field for displaying the question
  2 EditText fields for inputting the answer
  1 Button for submitting the answer
  1 TextView for displaying the correctness of the input answer and the
correct answer
  1 Button for proceeding to the next question.
  
  
If the question is about linear equation or if the question is about quadratic equation but there is
only one root, one of the EditText fields should be disabled.


<img src="https://cl.ly/0z0B2B3v3C2f/Screen%20Recording%202017-11-07%20at%2009.33%20%E4%B8%8B%E5%8D%88.gif" />


#### Part 3
A random question generato
The generated quadratic equation has real roots (that is determinant B2 – 4AC >= 0)
``` java
while ((question_no > linear_num  && ((B*B - 4 * A * C) < 0) ) || (A == 0)){
            A = random.nextInt(max) - subtraction;
            B = random.nextInt(max) - subtraction;
            C = random.nextInt(max) - subtraction;
        }
```

#### Part 4
Calculate the correct answer(s).
``` java

if (question_no > linear_num) {
        if (B * B - 4 * A * C == 0){
            res1 = -((double)B) / (2*A);
            res_num = 1;
            res2 = 0;
        } else {
            res_num = 2;
            res1 = (-((double)B) + sqrt(B * B - 4 * A * C)) / (2 * A);
            res2 = (-((double)B) - sqrt(B * B - 4 * A * C)) / (2 * A);
        }
}else{
    res_num = 1;
    res2 = 0;
    res1 = -((double)B) / A;
}
``` 
#### Part 5
<img src="https://cl.ly/2v260F2M2337/Screen%20Recording%202017-11-06%20at%2005.09%20%E4%B8%8B%E5%8D%88.gif" />

Display the generated question in proper format.


### Proper Format

#### Part 6
<img src="https://cl.ly/0z0o2n0y201M/Screen%20Recording%202017-11-06%20at%2005.15%20%E4%B8%8B%E5%8D%88.gif">
</img>
Error messages should be displayed if the answer is not of proper format.


### Answer Question
#### Part 7
<img src="https://cl.ly/0F3E2p3n1v0x/Screen%20Recording%202017-11-06%20at%2005.12%20%E4%B8%8B%E5%8D%88.gif">
</img>
Compare the input answer with the correct one.

You can get the right answer after you click “submit’ button, You can hear different audio effect when you get right and wrong answer.

``` java
if ((equal_res(user_answer1, res1) && res_num == 1) ||
                        (equal_res(user_answer1, res1) && equal_res(user_answer2, res2)) ||
                        (equal_res(user_answer1, res2) && equal_res(user_answer2, res1))) {
                    result = "Correct! ";
                    right += 1;
                    if (!mediaPlayerS.isPlaying()) {
                        mediaPlayerS.start();
                    }
                }else {
                    result = "Wrong! ";
                    wrong += 1;
                    if (!mediaPlayerF.isPlaying()) {
                        mediaPlayerF.start();
                    }
                }
```

#### Part 8
<img src="https://cl.ly/3H3M0J332u3d/Screen%20Recording%202017-11-07%20at%2009.56%20%E4%B8%8B%E5%8D%88.gif" />
Let the user proceed to the next question and repeat above.

### Finish it!
#### Part 9
<img src="https://cl.ly/2l1z1n1R0f3x/Screen%20Recording%202017-11-06%20at%2005.17%20%E4%B8%8B%E5%8D%88.gif">
</img>
After completing 10 questions, display a summary telling the user the number of questions that has answered correctly, wrongly and given up. The summary should also inform the user the average time spent on each linear equation question and that on each quadratic equation question.

### Bonus have done
Nice user interface. 
 && Fluent quiz flow.
 && Additional features

https://github.com/cokoro/equations_quiz/tree/master/sample/src/main/java/com/truizlop/fabreveallayoutsample2


https://github.com/cokoro/equations_quiz/tree/master/sample/src/main/res/layout
