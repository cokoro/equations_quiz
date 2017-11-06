# Equations_quiz 
<img src="https://cl.ly/253C1R0I391q/Image%202017-11-06%20at%205.08.28%20%E4%B8%8B%E5%8D%88.png" />

A layout to transition between two views using a Floating Action Button as shown in many Material Design concepts

### Usage

<img src="https://cl.ly/2v260F2M2337/Screen%20Recording%202017-11-06%20at%2005.09%20%E4%B8%8B%E5%8D%88.gif">
</img>

An Android application to practice students’ ability in solving algebraic equations. The application focus on linear and quadratic equations,in the form of a quiz in which 10 random questions are generated in sequence. The first 5 questions are about linear equation while the next 5 questions are about quadratic equation. 

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


### Answer Question

<img src="https://cl.ly/0F3E2p3n1v0x/Screen%20Recording%202017-11-06%20at%2005.12%20%E4%B8%8B%E5%8D%88.gif />

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


### Proper Format



<img src="https://cl.ly/2v260F2M2337/Screen%20Recording%202017-11-06%20at%2005.09%20%E4%B8%8B%E5%8D%88.gif />

Error messages should be displayed if the answer is not of proper format.

### Finish it!


<img src="https://cl.ly/2l1z1n1R0f3x/Screen%20Recording%202017-11-06%20at%2005.17%20%E4%B8%8B%E5%8D%88.gif />

After completing 10 questions, display a summary telling the user the number of questions that has answered correctly, wrongly and given up. The summary should also inform the user the average time spent on each linear equation question and that on each quadratic equation question.

