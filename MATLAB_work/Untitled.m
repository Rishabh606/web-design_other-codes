clc
clear all
close all
t=linspace(0,3*pi,1000);
n=linspace(1,700,700);
x=size(n);
an=zeros(1,x(1,2));
bn=zeros(1,x(1,2));
cn=zeros(1,x(1,2));
ta=zeros(1,x(1,2));
for i=1:1:x(1,2)
    p=@(t)exp(-t./2).*cos((2*n(1,i)*t));
    an(1,i)=(2*integral(p,0,pi))/(pi);
    q=@(t)exp(-t./2).*sin((2*n(1,i)*t));
    bn(1,i)=(2*integral(q,0,pi))/(pi);
end	
figure;
stem(an);
z=@(t) exp(-t/2);
y=integral(z,0,pi)/pi;
p=size(t);
f=zeros(1,p(1,2));

for i=1:1:p(1,2)
    g1=0;
    for j=1:1:x(1,2)
    g1=an(1,j).*cos(2*n(1,j)*t(1,i))+bn(1,j).*sin(2*n(1,j)*t(1,i))+g1;
    end 
f(1,i)=g1+y;
end
size(f)
figure;
plot(t,f);
