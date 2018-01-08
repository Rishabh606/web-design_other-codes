function [ y ] = xexp1( a,b )
%UNTITLED4 Summary of this function goes here
%   Detailed explanation goes here
t = (-10:0.01:10);
p= a*(ramp(1,4)-ramp(1,2)+unitstep_exp1(1,0)-ramp(1,-5))+b>=0;
y= (a*((ramp(1,4)-ramp(1,2)+unitstep_exp1(1,0)-ramp(t-5)))+b).*p;
end

