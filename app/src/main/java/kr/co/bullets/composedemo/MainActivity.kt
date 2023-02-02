package kr.co.bullets.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.bullets.composedemo.ui.theme.ComposeDemoTheme

// 다음으로 MainActivity 클래스는 안드로이드 ComponentActivity 클래스의 서브클래스로 선언된다.
class MainActivity : ComponentActivity() {
    // MainActivity 클래스는 onCreate() 형태의 단일 메서드를 구현한다. 이 메서드는 안드로이드 런타임 시스템에서
    // 액티비티가 시작될 때 호출되는 첫 번째 메서드이며, 컴포즈 도입 이전의 앱 개발 방식의 결과물이다.
    // 여기서 onCreate() 메서드는 메서드가 포함된 액티비티, 그리고 해당 액티비티안의 Compose 기반 사용자 인터페이스의 다리를 제공하는 역할을 한다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 이 메서드는 액티비티의 사용자 인터페이스 내용을 ComposeDemoTheme라는 컴포저블 함수에서 제공함을 선언한다.
            // 이 컴포저블 함수는 Project 도구 창의 app -> <패키지 이름> -> ui.theme 폴더 아래의 Theme.kt 파일에 선언되어 있다.
            // 이 함수는 ui.theme 폴더의 다른 파일들과 함께 액티비티에서 사용할 색상, 글꼴, 모양을 정의하고 앱 사용자 인터페이스의
            // 전체 테마를 커스터마이즈할 수 있는 중심 영역이다.
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme (테마의 'background' 색상을 이용하는 서피스 컨테이너)
                // ComposeDemoTheme 컴포저블 함수에 대한 호출은 Surface 컴포저블을 포함하도록 설정된다.
                // Surface는 내장 컴포즈 컴포넌트이며 다른 컴포저블의 배경을 제공한다.
                // 여기서 Surface 컴포넌트는 전체 화면을 채우고 배경 색상을 안드로이드의 머티리얼 디자인 테마에 정의된 표준 색상을 설정한다.
                // 머티리얼 디자인은 모든 안드로이드 앱에서 일관된 형태와 느낌을 제공하기 위해 구글에서 개발한 디자인 지침이다.
                // 머티리얼 디자인에는 테마(글꼴 및 색상 포함), 사용자 인터페이스 컴포넌트(예: 버튼, 텍스트 및 텍스트 필드 범위), 아이콘 등이 포함되며
                // 일반적으로 안드로이드 앱이 사용자 상호작용에 대해 어떻게 보이고 응답해야 하는지 정의되어 있다.
                // 마지막으로, Surface는 Greeting이라는 이름의 컴포저블 함수를 포함하며 이 함수는 "Android" 라는 문자열을 전달받는다.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun DemoText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

// MainActivity 클래스 밖의 액티비티 안에서 첫 번째 컴포저블 함수 선언이 나타난다.
// 이 함수의 이름은 Greeting이며, @Composable 애너테이션을 이용해 컴포저블로 표시된다.
// 이 함수는 문자열 파라미터(name)를 받아 내장 Text 컴포저블을 호출한다. 이때 "Hello" 문자열과 name 파라미터를 통해 받은 값을 전달한다.
// 이후 튜토리얼을 진행하면서 분명해지겠지만, 컴포저블 함수는 컴포즈를 이용해 안드로이드 앱을 개발하기 위한 기본 빌딩 블록이다.
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

// MainActivity.kt 파일에 선언된 두 번째 컴포저블 함수는 다음과 같다.

// 각각의 미리 보기는 @Preview 애너테이션에 파리미터를 전달해서 구성할 수 있다.
// 예를 들어, 나머지 표준 안드로이드 화면 데커레이션을 미리 보려면 다음과 같이 미리 보기 애너테이션을 수정한다.
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeDemoTheme {
//        Greeting("Compose")
//    }
//}

// 이번 장 앞부분에서 앱을 컴파일 및 실행하지 않아도 미리 보기 패널에서 사용자 인터페이스가 어떻게 표시되는지 확인하는 방법을 설명했다.
// 미리 보기 랜더링이 onCreate() 메서드의 코드에 의해 생성된다고 가정할 수도 있지만, 사실 이 메서드는 앱이 기기나 에뮬레이터에서 실행될 때만 호출된다.
// 미리 보기는 미리 보기 컴포저블 함수에 의해 만들어진다.
// 함수에 연결된 @Preview 애너테이션은 안드로이드 스튜디오에서 이 함수가 미리 보기 함수이며 함수에서 내보내는 콘텐츠를 미리 보기 패널에 표지할 것임을 알린다.
// 책의 뒤에서 확인하겠지만, 단일 액티비티에는 다양한 데이터값을 이용해서 사용자 인터페이스의 특정 영역을 미리 볼 수 있도록 구성하는 여러 기능을 포함할 수 있다.