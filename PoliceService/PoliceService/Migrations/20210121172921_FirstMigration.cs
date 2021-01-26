using System;
using Microsoft.EntityFrameworkCore.Migrations;
using MySql.Data.EntityFrameworkCore.Metadata;

namespace PoliceService.Migrations
{
    public partial class FirstMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "certificates",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    Type = table.Column<string>(nullable: true),
                    Brand = table.Column<string>(nullable: true),
                    RegistrationNumber = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_certificates", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "licences",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    LastName = table.Column<string>(nullable: true),
                    FirstName = table.Column<string>(nullable: true),
                    RegistrationNumber = table.Column<string>(nullable: true),
                    Address = table.Column<string>(nullable: true),
                    DateOfIssue = table.Column<DateTime>(nullable: false),
                    ValidUntil = table.Column<DateTime>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_licences", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "people",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    FirstName = table.Column<string>(nullable: true),
                    LastName = table.Column<string>(nullable: true),
                    UID = table.Column<string>(nullable: true),
                    FatherName = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_people", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "requests",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    personId = table.Column<int>(nullable: true),
                    weaponCertificateId = table.Column<int>(nullable: true),
                    Paid = table.Column<bool>(nullable: false),
                    Processed = table.Column<bool>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_requests", x => x.Id);
                    table.ForeignKey(
                        name: "FK_requests_people_personId",
                        column: x => x.personId,
                        principalTable: "people",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_requests_certificates_weaponCertificateId",
                        column: x => x.weaponCertificateId,
                        principalTable: "certificates",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_requests_personId",
                table: "requests",
                column: "personId");

            migrationBuilder.CreateIndex(
                name: "IX_requests_weaponCertificateId",
                table: "requests",
                column: "weaponCertificateId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "licences");

            migrationBuilder.DropTable(
                name: "requests");

            migrationBuilder.DropTable(
                name: "people");

            migrationBuilder.DropTable(
                name: "certificates");
        }
    }
}
