 
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DEVELOPER'S PROFILE</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <style>
        * {

            outline: none;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;

            background: url("#"), -webkit-linear-gradient(bottom, #118502, #042fbe);
        }

        .container {
            width: 1000px;
            background: #fff;
            text-align: center;
            border-radius: 10px;
            padding: 50px 35px 10px 35px;
        }

        .container header {
            font-size: 35px;
            font-weight: 600;
            margin: 0 0 30px 0;
            color: #0481f5;
        }

        .container .form-outer {
            width: 100%;
            overflow: hidden;
        }

        .form-outer form {
            width: 400%;
            display: flex;
        }

        .form-outer form .page {
            width: 25%;
        }

        .form-outer form .page .title {
            font-size: 25px;
            font-weight: 500;
        }

        .form-outer form .page .field {
            width: 330px;
            height: 45px;
            margin: 45px 330px;
            display: flex;
            position: relative;
        }

        form .page .field .label {
            position: absolute;
            top: -30px;
            font-weight: 500;
        }

        form .page .field input {
            height: 100%;
            width: 100%;
            border: 1px solid lightgrey;
            border-radius: 5px;
            padding-left: 15px;
            font-size: 18px;
        }

        form .page .field select {
            width: 100%;
            padding-left: 10px;
            font-size: 17px;
            font-weight: 500;
        }

        form .page .field button {
            width: 100%;
            height: calc(100% + 5px);
            border: none;
            background: #0481f5;
            margin-top: -20px;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            font-size: 18px;
            font-weight: 500;
            letter-spacing: 1px;
            text-transform: uppercase;
            transition: 0.5s ease;
        }

        form .page .field button:hover {
            background: #000;
        }

        form .page .btns button {
            margin-top: -20px !important;
        }

        form .page .btns button.prev {
            margin-right: 3px;
            font-size: 17px;
        }

        form .page .btns button.next {
            margin-left: 3px;
        }
        .container .progress-bar{
  display: flex;
  margin: 40px 0;
  user-select: none;
}
.container .progress-bar .step{
  text-align: center;
  width: 100%;
  position: relative;
}
.container .progress-bar .step p{
  font-weight: 500;
  font-size: 18px;
  color: #000;
  margin-bottom: 8px;
}
.progress-bar .step .bullet{
  height: 25px;
  width: 25px;
  border: 2px solid #000;
  display: inline-block;
  border-radius: 50%;
  position: relative;
  transition: 0.2s;
  font-weight: 500;
  font-size: 17px;
  line-height: 25px;
}
.progress-bar .step .bullet.active{
  border-color:#0481f5;
  background: #0481f5;;
}
.progress-bar .step .bullet span{
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}
.progress-bar .step .bullet.active span{
  display: none;
}
.progress-bar .step .bullet:before,
.progress-bar .step .bullet:after{
  position: absolute;
  content: '';
  bottom: 11px;
  right: -140px;
  height: 3px;
  width: 140px;
  background: #262626;
}
.progress-bar .step .bullet.active:after{
  background: #0481f5;
  transform: scaleX(0);
  transform-origin: left;
  animation: animate 0.3s linear forwards;
}
@keyframes animate {
  100%{
    transform: scaleX(1);
  }
}
.progress-bar .step:last-child .bullet:before,
.progress-bar .step:last-child .bullet:after{
  display: none;
}
.progress-bar .step p.active{
  color: #0481f5;
  transition: 0.2s linear;
}
.progress-bar .step .check{
  position: absolute;
  left: 50%;
  top: 75%;
  font-size: 15px;
  transform: translate(-50%, -50%);
  display: none;
}
.progress-bar .step .check.active{
  display: block;
  color: #fff;
}
    </style>
</head>

<div class="container">
        <header>Developer's Profile</header>
        <div class="progress-bar">
            <div class="step">
                <p>
                    Profile</p>
                <div class="bullet">
                    <span>1</span>
                </div>
                <div class="check fas fa-check">
                </div>
            </div>
            <div class="step">
                <p>
                    Carrier Objective</p>
                <div class="bullet">
                    <span>2</span>
                </div>
                <div class="check fas fa-check">
                </div>
            </div>
            <div class="step">
                <p>
                    Technical Skill Set</p>
                <div class="bullet">
                    <span>3</span>
                </div>
                <div class="check fas fa-check">
                </div>
            </div>
            <div class="step">
                <p>
                    Educational Details</p>
                <div class="bullet">
                    <span>4</span>
                </div>
                <div class="check fas fa-check">
                </div>
            </div>
            <div class="step">
                <p> 
                <div class="bullet">
                    <span>5</span>
                </div>
                <div class="check fas fa-check">
                </div>
            </div>
            <div class="step">
                <p>
                    Project Details</p>
                <div class="bullet">
                    <span>6</span>
                </div>
                <div class="check fas fa-check">
                </div>
            </div>
        </div>
        
        
 <div class="page">
                    <div class="title">
                        Technical Skill Set:</div>
                    <div class="field">
                        <div class="label">
                            Skills</div>
                        <select>
                            <option></option>
                            <option>C</option>
                            <option>C++</option>
                            <option>JAVA</option>
                            <option>Advanced JAVA</option>
                            <option>J2EE</option>
                            <option>HTML</option>
                            <option>JAVA</option>
                            <option>CSS</option>
                            <option>JSP</option>
                            <option>Angilar JS</option>
                            <option>Node JS</option>
                            <option>Javascrit</option>
                            <option>SQL</option>
                            <option>API</option>
                            <option>Spring Hibernet</option>
                        </select>
                    </div>
                    <div class="field btns">
                        <button class="prev-2 prev">Previous</button>
                        <button class="next-2 next">Next</button>
                    </div>
                </div>                 </form>
        </div>
    </div><body>
    
     <script>

        const slidePage = document.querySelector(".slide-page");
        const nextBtnFirst = document.querySelector(".firstNext");
        const prevBtnSec = document.querySelector(".prev-1");
        const nextBtnSec = document.querySelector(".next-1");
        const prevBtnThird = document.querySelector(".prev-2");
        const nextBtnThird = document.querySelector(".next-2");
        const prevBtnFourth = document.querySelector(".prev-3");
        const nextBtnFourth = document.querySelector(".next-3");
        const prevBtnFifth = document.querySelector(".prev-4");
        const nextBtnFifth = document.querySelector(".next-4");
        const prevBtnSixth = document.querySelector(".prev-5");
        const submitBtn = document.querySelector(".submit");
        const progressText = document.querySelectorAll(".step p");
        const progressCheck = document.querySelectorAll(".step .check");
        const bullet = document.querySelectorAll(".step .bullet");
        let current = 1;

        nextBtnFirst.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-25%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        nextBtnSec.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-50%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        nextBtnThird.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-75%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        nextBtnFourth.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-100%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        nextBtnFifth.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-125%";
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
        });
        submitBtn.addEventListener("click", function () {
            bullet[current - 1].classList.add("active");
            progressCheck[current - 1].classList.add("active");
            progressText[current - 1].classList.add("active");
            current += 1;
            setTimeout(function () {
                alert("Your Form Successfully Submited");
                location.reload();
            }, 800);
        });

        prevBtnSec.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "0%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        prevBtnThird.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-25%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        prevBtnFourth.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-50%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        prevBtnFifth.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-75%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
        prevBtnSixth.addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = "-100%";
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
    </script> 
</body> 

</html>
 
               

</body>
</html>