clc
clear all
close all
 
 
n=linspace(0,20,21);
y(21)=0;
i = 1;
for r1 =-10:1:10
convo = @(n) sin((2*pi*n)/8).*(heaviside(n)-heaviside(n-5)).*(exp(-3*(n-r1)).*(heaviside(n-r1)-heaviside(n-4-r1)));
y(1,i) = integral(convo,-10,10);
i = i+1 ;
end
subplot(3,2,1);
plot(n,y);
grid on;
axis([-30 30 -1 1]);
title('Question 1');
 
b=sin((2*pi*n)/8).*(heaviside(n)-heaviside(n-5));
c=exp(-3*(n)).*(heaviside(n)-heaviside(n-4));
my=xcorr(b,c);
n2=linspace(0,20,41);
subplot(3,2,2);
plot(n2,my);
%axis([-30 30 -1.5 1.5]);
title(' Question 1');
 
i = 1;
for r1 =-10:1:10
   convo = @(n) ((heaviside(n)-heaviside(n-5)).*(heaviside(n-r1)-heaviside(n-4-r1)));
   y(1,i) = integral(convo,-10,10);
   i = i+1 ;
end
subplot(3,2,3);
plot(n,y);
grid on;
axis([0 30 0 5]);
title(' Question 2');
 
b=sin((heaviside(n)-heaviside(n-5)));
c=heaviside(n-r1)-heaviside(n-4-r1);
my=xcorr(b,c);
subplot(3,2,4);
plot(n2,my);
%([-30 30 -15 15]);
title(' Question 2');
 
% problem 3
 
x=[2 5 6 8 7];
x1=[0 5 0 6 0];
subplot(3,2,5);
l=correlation(x1,x1);
stem(l);
title(' Question 3 i');
subplot(3,2,6);
k=xcorr(x1);
stem(k);
title(' Question 3 i');

figure();
x2=[2 0 5 0 6 0 8 0 7];
subplot(1,2,1);
l=correlation(x2,x2);
stem(l);
subplot(1,2,2);
k=xcorr(x2);
stem(k);


%que 4

t = -5:.1:5;
x = exp(-3*t).*heaviside(t);
y = corr(x,x,t);
figure();
subplot(1,2,1)
stem(y);
title('Q4');
z=xcorr(x);
subplot(1,2,2)
stem(z);
title('Q4');

% problem 5 1

fun1=@(t) (unit(t)-unit(t-5)).^2;
ex=integral(fun1,-inf,inf);
fun2=@(t) (exp(-t./5).*(unit(t)-unit(t-5))).^2;
ey=integral(fun2,-inf,inf);
fun3=@(t) (unit(t)-unit(t-5)).*(exp(-t./5).*(unit(t)-unit(t-5)));  
cn=((ex*ey)^(-1/2))*integral(fun3,-inf,inf);
disp('cn=');
disp(cn);

% problem 5 2 

fun1=@(t) (unit(t)-unit(t-5)).^2;
ex2=integral(fun1,-inf,inf);
fun2=@(t) (sin(2.*pi.*t).*(unit(t)-unit(t-5))).^2;
ey2=integral(fun2,-inf,inf);
fun3=@(t) (unit(t)-unit(t-5)).*(sin(2.*pi.*t).*(unit(t)-unit(t-5)));  
cn2=((ex2*ey2)^(-1/2))*integral(fun3,-inf,inf);
disp('cn2=');
disp(cn2);


