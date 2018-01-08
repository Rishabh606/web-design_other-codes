clc;
clear all;
close all;
%Part A
x = -10:1:10;
unitstep = x>=0;
subplot(4,5,1);
plot(x,unitstep);

x = -10:1:10;
y= x;
subplot(4,5,2);
plot(x,y);

x = -10:1/10:10;
unitstep = x==0;
subplot(4,5,3);
plot(x,unitstep);

t=(-4:0.01:4);
sgn= (t>=0)-((t)<=0);
subplot(4,5,4);
plot(t,sgn);
 
t=(-4:0.01:4)';
y= 2*exp(3*t);
subplot(4,5,5);
plot(t,y);
 
t= -2:1/100:2;
rt= exp(2*t).*cos(3*t);
it = exp(2*t).*sin(3*t);
subplot(4,5,6);
plot3(it,rt,t)

t = -1:1/1000:1;
y = exp(-3*abs(t));
subplot(4,5,7);
plot(t,y)

t = -1:1/1000:1;
y = exp(-3*t.*t);
subplot(4,5,8);
plot(t,y)

x = 0:pi/100:2*pi;
y = sin(x*8);
subplot(4,5,9);
plot(x,y);

t=-10:0.1:10;
y=sinc(t);
subplot(4,5,10);
plot(t,y);

unitstep = t>=0;
unitstep5 = t>=0;
subplot(4,5,11);
plot(0.5*((cos(3*pi*t)).*unitstep+(cos(3*pi*-t)).*unitstep5));
grid on;


subplot(4,5,12);
plot(0.5*((sin(3*pi*t)).*unitstep-(sin(3*pi*-t)).*unitstep5));
grid on;


%Part B
x = 0:pi/100:2*pi;
y = sin(x*sqrt(2))+sin(2*t);
subplot(4,5,13);
plot(x,y);
grid on;

x = 0:pi/100:2*pi;
unitstep = x>=0;
y = cos(x*2*pi+pi/3).*unitstep;
subplot(4,5,14);
plot(x,y);
grid on;

y = unitstep(1,1/2)-unitstep3(1,-1/2);
subplot(4,5,15);
plot(y)
grid on;

y = ramp(1,1)-2*ramp(1,0)+ramp(1,-1);
subplot(4,5,16);
plot(y)
grid on;

p =ramp(2,11/6)-2*ramp(2,5/6)+ramp(2,-1/6);
subplot(4,5,17);
plot(p);
grid on;
