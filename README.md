# Equations_quiz 
[![Android Arsenal](https://cl.ly/253C1R0I391q)

A layout to transition between two views using a Floating Action Button as shown in many Material Design concepts

### Usage

![Sample 1](https://cl.ly/2v260F2M2337)

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

![Sample 2](https://cl.ly/0F3E2p3n1v0x)

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

![Sample 3](https://cl.ly/0z0o2n0y201M)

Error messages should be displayed if the answer is not of proper format.

### Finish it!

![Sample 3](https://cl.ly/2l1z1n1R0f3x)

After completing 10 questions, display a summary telling the user the number of questions that has answered correctly, wrongly and given up. The summary should also inform the user the average time spent on each linear equation question and that on each quadratic equation question.

