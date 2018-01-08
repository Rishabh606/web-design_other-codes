clc
clear all
close all
x=(-2:.0001:2);
z=(x+1).*((x+1)>=0);
d=x.*(x>=0);
w=(x-1).*((x-1)>=0);
e=z-2*d+w;
plot(x,e)