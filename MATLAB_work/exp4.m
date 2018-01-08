clc
clear all;
close all;

syms t;

yn1 = dsolve('D2y+4*Dy+4*y=0', 'y(0) = 3','Dy(0)=-7','t');
Pyn1 = 3*diff(yn1,t)+5*yn1;

display(Pyn1);
%ans is 5*delta(t)+Pyn1*u(t)

yn2 = dsolve('0*D2y+ Dy+5*y=0', 'y(0) = 5','t');
p2 = yn2;
display(p2);
%ans is 1*delta(t)+Pyn2*u(t)
yn3 = dsolve('D2y+2*Dy=0', 'y(0) = 0','Dy(0)=4','t');
p3 = 0;
display(p3);
%ans is 0*delta(t)+Pyn3*u(t)

yn4 = dsolve('D2y+5*Dy+6*y=0', 'y(0) = 0','Dy(0)=1','t');
p4 =  diff(yn4,t)+1*yn4;
display(p4);
%ans is 1*delta(t)+Pyn4*u(t)
yn5 = dsolve('D2y+2*Dy+1*y=0', 'y(0) = 0','Dy(0)=1','t');
p5 =  diff(yn5,t);
display(p5);
%ans is 0*delta(t)+Pyn5*u(t)
yn6 = dsolve('D2y+3*Dy+2*y=0', 'y(0) = 0','Dy(0)=1','t');
p6 =  diff(yn6,t);
display(p6);
%ans is 0*delta(t)+Pyn6*u(t)


